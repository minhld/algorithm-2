package com.usu.structs.test;

import com.usu.structs.HashMap;

public class testHashTable extends Thread {
	public void run() {
		// testExistingTable();
		testHashMap();
	}
	
	public void testHashMap() {
		HashMap<String, Long> hash = new HashMap<>();
		hash.put("A", 1l);
		hash.put("B", 5l);
		hash.put("A", 8l);
		hash.put("D", 3l);
		hash.put("C", 9l);
		hash.put("F", 2l);
		
		System.out.println("val: " + hash.get("C"));
	}
	
	public void testExistingTable() {
		java.util.HashMap<String, String> hash = new java.util.HashMap<>();
		hash.put("A", "ACF");
		String a = hash.get("A");
		System.out.println("ABCDEFGHIZKLMKL".hashCode());
	}
	
	public static void main(String args[]) {
		new testHashTable().start();
	}
}
