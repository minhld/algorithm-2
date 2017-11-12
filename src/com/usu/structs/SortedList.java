package com.usu.structs;

public class SortedList<T> extends LinkedList<T> {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void add(T v) {
		Link<T> newL = new Link<T>(v);
		
		if (first == null) {
			first = newL; 
			return;
		}
		
		Link<T> l = first;
		Link<T> p = null;	// hold a previous link
		while (l != null && ((Comparable)v).compareTo(l.data) > 0) {
			p = l;
			l = l.next;
		}
		
		// insert into appropriate position
		p.next = newL;
		newL.next = l;
	}
}
