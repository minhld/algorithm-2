package com.usu.structs;

/**
 * Link is an item of Linked List
 * 
 * @author minhle
 *
 */
public class Link<T> {
	public T data;
	public Link<T> next;
	
	public Link(T data) {
		this.data = data;
	}
	
	public void display() {
		System.out.print(data + " ");
	}
}
