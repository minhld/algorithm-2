package com.usu.test.ctci;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class test73_jukebox {
	
	public static void main(String args[]) {
		HashMap<String, String> list = new HashMap<>();
		list.put("B", "BBB");
		list.put("C", "CCC");
		list.put("A", "AAA");
		list.put("E", "PFG");
		list.put("R", "ALV");
		list.put("YH", "OSQ");
		list.put("ZA", "SAM");
		list.put("OK", "SDJ");
		
		Collection<String> set = list.values();
		List<String> setList = new ArrayList<>(set);
		for (String s : setList) {
			System.out.println(s);
		}
		
		Collections.sort(setList);
		for (String s : setList) {
			System.out.println(s);
		}
		
	}
	
	public class JukeBox {
		Song currentSong; 
		
		public void play(Song song) {
			currentSong = song;
		}
		
		public void play(Playlist playlist) {
			List<Song> songList = playlist.getSongs();
			for (Song s : songList) {
				play(s);
			}
		}
		
		public void play(CD cd) {
			List<Song> songList = cd.getSongs();
			for (Song s : songList) {
				play(s);
			}
		}
		
		public Song getCurrentSong() {
			return currentSong;
		}
	}
	
	public class Song {
		public String name;
		public Artist artist;
		public long duration;
		
		public Song(String n) {
			name = n;
			artist = new Artist();
		}
		
		public Song(String n, Artist a) {
			name = n;
			artist = a;
			duration = 0;
		}
		
		public Song(String n, Artist a, long dur) {
			name = n;
			artist = a;
			duration = dur;
		}
	}
	
	public class Artist {
		public String name = "Unknown";
	}
	
	public class Playlist {
		HashMap<String, Song> list = new HashMap<>(); 
		
		public void add(Song s) {
			list.put(s.name, s);
		}
		
		public void remove(String songName) {
			list.remove(songName);
		}
		
		public List<Song> getSongs() {
			return new ArrayList<>(list.values());
		}
	}
	
	public class CD extends Playlist {
		
	}
	
}
