package com.usu.test.ctci;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class test75_onlinebook {
	public class BookReaderSystem {
		// users who are online
		HashMap<Integer, User> onlineUsers = new HashMap<>();
		// books that being read
		HashMap<Integer, Book> onlineBooks = new HashMap<>();
		
		Library library = new Library();
		UserList userList = new UserList();
		
		public void readBook(User u, Book b) {
			Display dp = new Display(u, b);
			dp.openBook();
		}
		
		public List<Book> searchBook(String keys) {
			return library.searchBooks(keys);
		}
		
		public void registerUser(String name) {
			User user = new User();
			user.name = name;
			userList.addUser(user);
		}
		
		public void login(User user) {
			user.setActive(true);
			onlineUsers.put(user.id, user);
		}
		
		public void logout(User user) {
			onlineUsers.remove(user.id);
		}
	}
	
	public class Display {
		public User readingUser;
		public Book readingBook;
		private int pageIndex;
		
		public Display(User ru, Book rb) {
			readingUser = ru;
			readingBook = rb;
			pageIndex = 0;
		}
		
		public Page openBook() {
			return readingBook.getPage(pageIndex);
		}
		
		public Page nextPage() {
			if (pageIndex < readingBook.totalPages - 1) {
				pageIndex++;
			}
			return readingBook.getPage(pageIndex);
		}
		
		public Page prevPage() {
			if (pageIndex > 0) {
				pageIndex--;
			}
			return readingBook.getPage(pageIndex);
		}
	}
	
	public class UserList {
		public int maxId;
		
		HashMap<String, User> userList = new HashMap<>();
		
		public void addUser(User user) {
			user.id = maxId++;
			userList.put(user.name, user);
		}
		
		public void removeUser(String name) {
			userList.remove(name);
		}
		
		public List<Book> searchBooks(String keys) {
			List<Book> results = new ArrayList<>();
			
			return results;
		}
	}
	
	public class Library {
		HashMap<String, Book> bookList = new HashMap<>();
		
		public void addBook(Book b) {
			bookList.put(b.name, b);
		}
		
		public void removeBook(String name) {
			bookList.remove(name);
		}
		
		public List<Book> searchBooks(String keys) {
			List<Book> results = new ArrayList<>();
			
			return results;
		}
	}
	
	public class User {
		public int id;
		public String name;
		public boolean active;
		
		public void setActive(boolean act) {
			active = act;
		}
		
		public boolean isActive() {
			return active;
		}
	}
	
	public class Book {
		public int id;
		public String name;
		public int totalPages;
		public Page[] pages;
		
		public Page getPage(int idx) {
			return pages[idx];
		}
	}
	
	public class Page {
		Image contents;
	}
}
