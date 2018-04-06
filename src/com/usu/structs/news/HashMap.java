package com.usu.structs.news;

/**
 * @author Minh Le
 *
 * @param <A> keys
 * @param <B> values
 */
@SuppressWarnings("unchecked")
public class HashMap<A, B> {
	public static final int MAX_CAPACITY = 100; 
	LinkedListX<A, B>[] array;
	int capacity = 0;
	
	public HashMap() {
		this(MAX_CAPACITY);
	}
	
	public HashMap(int cap) {
		capacity = cap;
		array = new LinkedListX[cap];
	}
	
	public void put(A key, B val) {
		int listIndex = hashCode(key);
		LinkedListX<A, B> list = array[listIndex];
		if (list == null) {
			list = new LinkedListX<>();
		} 
		
		// delete existing item
		list.delete(key);
		list.addFirst(key, val);
	}
	
	public B get(A key) {
		int listIndex = hashCode(key);
		LinkedListX<A, B> list = array[listIndex];
		if (list == null) return null;
		
		return list.find(key);
	}
	
	public boolean containsKey(A key) {
		return get(key) != null;
	}
	
	public B remove(A key) {
		int listIndex = hashCode(key);
		LinkedListX<A, B> list = array[listIndex];
		if (list == null) return null;
		
		return list.delete(key);
	}
	
	public int size() {
		int count = 0;
		for (LinkedListX<A, B> list : array) {
			if (list != null) count += list.size();
		}
		return count;
	}
	
	private int hashCode(A key) {
		int hashedKey = key.hashCode() % capacity;
		return (hashedKey > 0 ? hashedKey : -1 * hashedKey); 
	}
}
