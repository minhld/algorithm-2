package com.usu.structs.news;

/**
 * Link is an item of Linked List
 * 
 * @author minhle
 *
 */
public class ListNode<T> {
	public T data;
	public ListNode<T> next;
	
	public ListNode(T data) {
		this.data = data;
	}
	
	public void display() {
		System.out.print(data + " ");
	}
}
