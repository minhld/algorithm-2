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
	
	
	public Link<T> addFirst(T data) {
		Link<T> l = new Link<T>(data);
		l.next = first;
		first = l;
		return first;
	}
	
	public Link<T> removeFirst() {
		// if list is empty
		if (isEmpty()) return null;
		
		Link<T> rem = first;
		first = first.next;
		return rem;
	}
	
	public Link<T> peek() {
		return first;
	}
	
	public Link<T> find(T key) {
		Link<T> f = first;

		// travel the list and check if f's value equals
		// to the key
		while (f != null && !f.data.equals(key)) {
			f = f.next;
		}

		return f;
	}
	
	public Link<T> delete(T key) {
		Link<T> p = null;	// previous link of the first
		Link<T> f = first;

		// travel the list and check if f's value equals
		// to the key, update the p-link too
		while (f != null && !f.data.equals(key)) {
			p = f;
			f = f.next;
		}

		if (p != null && f != null) {
			p.next = f.next;
		} else if (p == null && f != null) {
			// found at the first link
			first = null;
		}
		
		return f;
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
	
	public int size() {
		int count = 0;
		Link<T> c = first;
		while (c != null) {
			c = c.next;
			count++;
		}
		return count;
	}
}
