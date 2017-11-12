package com.usu.structs;

/**
 * provide functions: 
 * 	- push, pop, peek, isEmpty, size
 * 
 * @author minhle
 *
 * @param <T>
 */
public class LinkStack<T> {
	LinkedList<T> list;
	
	public LinkStack() {
		list = new LinkedList<>();
	}
	
	public T push(T val) {
		list.addFirst(val);
		return val;
	}
	
	public T pop() {
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
	 * this will flush out the entire stack
	 */
	public static <T> void print(LinkStack<T> s) {
		while (!s.isEmpty()) {
			T e = s.pop();
			System.out.print(e + " ");
		}
	}
}
