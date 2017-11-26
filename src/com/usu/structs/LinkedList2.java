package com.usu.structs;

/**
 * LinkedList2 accepts 2 generic classes. It provides
 * 	- addFirst, removeFirst, isEmpty
 *  
 * @author minhle
 *
 */
public class LinkedList2<A, T> {
	Link first;
	
	
	public Link addFirst(A key, T data) {
		Link l = new Link(key, data);
		l.next = first;
		first = l;
		return first;
	}
	
	public Link removeFirst() {
		// if list is empty
		if (isEmpty()) return null;
		
		Link rem = first;
		first = first.next;
		return rem;
	}
	
	public Link peek() {
		return first;
	}
	
	public Link find(A key) {
		Link f = first;

		// travel the list and check if f's value equals
		// to the key
		while (f != null && !f.key.equals(key)) {
			f = f.next;
		}

		return f;
	}
	
	public Link delete(A key) {
		Link p = null;	// previous link of the first
		Link f = first;

		// travel the list and check if f's value equals
		// to the key, update the p-link too
		while (f != null && !f.key.equals(key)) {
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
		Link c = first;
		while (c != null) {
			c.display();
			c = c.next;
		}
		System.out.println();
	}
	
	public int size() {
		int count = 0;
		Link c = first;
		while (c != null) {
			c = c.next;
			count++;
		}
		return count;
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		Link c = first;
		while (c != null) {
			str.append(c.data + " ");
			c = c.next;
		}
		return str.toString();
	}
	
	class Link {
		public A key;
		public T data;
		public Link next;
		
		public Link(A key, T data) {
			this.key = key;
			this.data = data;
		}
		
		public void display() {
			System.out.print(data + " ");
		}
		
		@Override
		public String toString() {
			return data + " ";
		}
	}
}
