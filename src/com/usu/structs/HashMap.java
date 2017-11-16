package com.usu.structs;

/**
 * 
 * @author minhld
 *
 * @param <A>
 * @param <B>
 */
@SuppressWarnings("unchecked")
public class HashMap<A, B> {
	private LinkedList2<A, B>[] list;
	private int capacity;
	
	public HashMap() {
		this.capacity = 100; 
		list = new LinkedList2[this.capacity];
	}
	
	public HashMap(int capacity) {
		this.capacity = capacity;
		list = new LinkedList2[this.capacity];
	}
	
	private int hashCode(A key) {
		return key.hashCode() % capacity;
	}
	
	/**
	 * 
	 * @param key
	 * @return the previous value associated with key, or null if there was no mapping for key.
	 */
	public B put(A key, B data) {
		int hashedKey = hashCode(key);
		LinkedList2<A, B> bList = list[hashedKey];
		if (bList == null) {
			bList = new LinkedList2<>();
			list[hashedKey] = bList;
		}
		
		// delete the existing item before adding
		com.usu.structs.LinkedList2<A, B>.Link l = bList.delete(key);
		bList.addFirst(key, data);
		
		return l != null ? l.data : null;
	}
	
	public B get(A key) {
		int hashedKey = hashCode(key);
		LinkedList2<A, B> bList = list[hashedKey];

		// find the key
		if (bList != null) {
			com.usu.structs.LinkedList2<A, B>.Link l = bList.find(key);
			return l != null ? l.data : null;
		}
		
		// not found
		return null;
	}
	
	/**
	 * remove a key out of the hash-map
	 * 
	 * @param key
	 * @return  the previous value associated with key, 
	 * 			or null if there was no mapping for key
	 */
	public B remove(A key) {
		int hashedKey = hashCode(key);
		LinkedList2<A, B> bList = list[hashedKey];
		com.usu.structs.LinkedList2<A, B>.Link l = bList.delete(key);
		return l != null ? l.data : null;
	}
	
	public int size() {
		int count = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				count += list[i].size();
			}
		}
		return count;
	}
	
}
