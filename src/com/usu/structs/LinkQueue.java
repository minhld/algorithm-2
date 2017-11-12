package com.usu.structs;

/**
 * provide functions:
 * 	- add, remove, peek, isEmpty, isFull, size
 * 
 * @author minhle
 *
 * @param <T>
 */
public class LinkQueue<T> {
	DLinkedList<T> list;
	
	public LinkQueue() {
		list = new DLinkedList<>();
	}
	
	public boolean add(T val) {
		list.addLast(val);
		return true;
	}
	
	public T remove() {
		Link<T> r = list.removeFirst();
		return r != null ? r.data : null;
	}
	
	public T peek() {
		Link<T> p = list.peek();
		return p != null ? p.data : null;
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public int size() {
		return list.size();
	}
	
	/**
	 * this will flush out the entire queue
	 */
	public static <T> void print(LinkQueue<T> s) {
		while (!s.isEmpty()) {
			T e = s.remove();
			System.out.print(e + " ");
		}
	}
}
