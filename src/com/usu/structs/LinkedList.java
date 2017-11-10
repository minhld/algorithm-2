package com.usu.structs;

/**
 * provide functions
 * 	- addFirst, removeFirst, isEmpty
 *  
 * @author minhle
 *
 */
public class LinkedList<T> {
	Link<T> first;
	
	public void addFirst(T data) {
		Link<T> l = new Link<T>(data);
		l.next = first;
		first = l;
	}
	
	public Link<T> removeFirst() {
		// if list is empty
		if (isEmpty()) return null;
		
		Link<T> rem = first;
		first = first.next;
		return rem;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void display() {
		Link<T> c = first;
		while (c != null) {
			c.display();
			c = c.next;
		}
		System.out.println();
	}
}
