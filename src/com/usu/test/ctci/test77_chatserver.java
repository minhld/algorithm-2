package com.usu.test.ctci;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class test77_chatserver {

	public class ChatServer {
		HashMap<String, ChatRoom> roomList = new HashMap<>();
		SocketManager socketManager;
		UserManager userManager;
		String host;
		
		public ChatServer() {
			socketManager = new SocketManager();
			host = getHostIp();
		}
		
		public void startServer(String host, int port) {
			socketManager.start(host, port);
		}
		
		public void createNewRoom(User owner, String roomName) { 
			ChatRoom cr = new ChatRoom(owner, roomName);
			cr.startRoom();
			roomList.put(roomName, cr);
		}
		
		public void registerUser(User user) { userManager.registerUser(user); }
		public String getHostIp() { return ""; }
	}
	
	
	public class ChatRoom {
		String name;
		User owner;
		HashMap<String, User> userList = new HashMap<>();
		SocketChannel channel;
		
		public ChatRoom(User own, String rName) {
			owner = own;
			name = rName;
			channel = new SocketChannel(name);
		}
		
		public void startRoom() { 
			channel.start();
		}

		public void addMoreUser(User user) { }
		public void sendMessage(Message message) { channel.sendMessage(message); }
		public void closeRoom() { channel.end(); }
	
	}
	
	public class SocketManager {
		HashMap<String, SocketChannel> socketList = new HashMap<>();
		
		public void start(String host, int port) { }
		
		public void close() { 
			for (SocketChannel client : socketList.values()) {
				client.end();
			}
		}
	}
	
	public class SocketChannel {
		public String name;
		
		public SocketChannel(String n) { name = n; }
		
		public void sendMessage(Message message) { }
		
		public void start() { }
		public void end() { }
	}
	
	public class UserManager {
		HashMap<String, User> userList = new HashMap<>();
		
		public void registerUser(User user) { 
			if (!isUserRegister(user)) {
				addUser(user);
			}
		}
		
		public boolean isUserRegister(User user) { 
			return userList.containsKey(user.name);
		} 
		
		public void addUser(User user) { 
			userList.put(user.name, user);
		}
		
		public void removeUser(User user) { }
		public List<User> searchUser(String keys) { return null; }
	}
	
	public class User {
		public int id;
		public String name;
		public HashSet<String> roomList = new HashSet<>();
		
		public List<String> getRoomList() {
			return new ArrayList<String>(roomList);
		}
	}
	
	public class Message {
		public Date time;
		public String content;
		public User from;
		public User to;
	}
}
