package com.usu.structs;

/**
 * extending these functions
 * 	- addLast, removeLast
 *  
 * @author minhle
 *
 */
public class DLinkedList<T> extends LinkedList<T> {
	Link<T> last;

	@Override
	public Link<T> addFirst(T data) {
		Link<T> f = super.addFirst(data);
		// update the last link
		if (last == null) {
			last = f;
		}
		return f;
	}
	
	@Override
	public Link<T> removeFirst() {
		Link<T> r = super.removeFirst();
		// update the last
		if (isEmpty()) last = null;
		return r;
	}
	
	/**
	 * add item to the last position of the list
	 * 
	 * @param data
	 */
	public void addLast(T data) {
		Link<T> l = new Link<T>(data);
		if (last != null) {
			last.next = l;
		} else {
			first = l;
		}
		last = l;
	}
	
	public void displayLast() {
		Link<T> l;
		while ((l = removeFirst()) != null) {
			System.out.print(l.data + " ");
		}
		System.out.println();
	}
}
