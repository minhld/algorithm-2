package com.usu.structs.news;

/**
 * @author Minh Le
 *
 * @param <A> keys
 * @param <B> values
 */
public class LinkedListX<A, B> {
	Link first;
	Link last;
	
	public Link addFirst(A key, B val) {
		Link l = new Link(key, val);
		l.next = first;
		first = l;
		return first;
	}
	
	public Link removeFirst() {
		if (isEmpty()) return null;
		
		Link rem = first;
		first = first.next;
		return rem;
	}
	
	public Link peek() {
		return first;
	}
	
	public Link peekLast() {
		return last;
	}
	
	public B find(A key) {
		Link c = first;
		while (c != null && c.key.equals(key)) {
			c = c.next;
		}
		return (c != null ? c.val : null);
	}
	
	public B delete(A key) {
		Link p = null;
		Link c = first;
		
		while (c != null && !c.val.equals(key)) {
			p = c;
			c = c.next;
		}
		
		if (p != null && c != null) {
			// the delete node is at the middle
			p.next = c.next;
		} else if (p == null && c != null) {
			// the delete node is the first
			first = c.next;
		}
		
		return c.val;
	}
	
	public boolean isEmpty() {
		return first == null;
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
			str.append(c.toString());
			c = c.next;
		}
		return str.toString();
	}
		
	class Link {
		public A key;
		public B val;
		public Link next;
		public Link prev;
		
		public Link(A k, B v) {
			key = k;
			val = v;
		}
		
		@Override
		public String toString() { return val + " "; }
	}
}
