package com.usu.structs.news;

public class LinkedList<T> {
	ListNode<T> head;
	
	public ListNode<T> addFirst(T val) {
		ListNode<T> node = new ListNode<>(val);
		node.next = head;
		head = node;
		return head;
	}
	
	public ListNode<T> removeFirst() {
		ListNode<T> first = head;
		if (head != null) {
			head = head.next;
		}
		return first;
	}
	
	public ListNode<T> peek() {
		return head;
	}
	
	public ListNode<T> find(T key) {
		ListNode<T> c = head;
		while (c != null && !c.val.equals(key)) {
			c = c.next;
		}
		return c;
	}
	
	public ListNode<T> delete(T key) {
		ListNode<T> p = null;
		ListNode<T> c = head;
		
		while (c != null) {
			if (c.val.equals(key)) {
				if (p != null) {
					p.next = c.next;
				} else {
					head = c.next;
				}
				return c;
			} else {
				p = c;
				c = c.next;
			}
		}
		
		return null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	
	@SuppressWarnings("rawtypes")
	public static void display(ListNode h) {
		ListNode c = h;
		while (c != null) {
			c.display();
			c = c.next;
		}
		System.out.println();
	}
	
	public void display() {
		ListNode<T> c = head;
		while (c != null) {
			c.display();
			c = c.next;
		}
		System.out.println();
	}
	
	public int size() {
		int numElms = 0;
		ListNode<T> c = head;
		while (c != null) {
			c = c.next;
			numElms++;
		}
		return numElms;
	}
}
