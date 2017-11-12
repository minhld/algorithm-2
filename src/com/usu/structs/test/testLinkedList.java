package com.usu.structs.test;

import com.usu.structs.Array;
import com.usu.structs.DLinkedList;
import com.usu.structs.Link;
import com.usu.structs.LinkedList;
import com.usu.test.utils.Utils;

public class testLinkedList extends Thread {
	public void run() {
//		testLinkedList1();
//		testLinkedList2();
		testDLinkedList1();
		
//		long[] a1 = new long[] { 1, 2, 3 };
//		long[] a2 = new long[] { 5, 6, 7 };
//		long[] a3 = a1;
//		a1 = a2;
//		Array.print(a1);
//		Array.print(a2);
//		Array.print(a3);
	}
	
	public void testDLinkedList1() {
		long[] a = Utils.createArray(10, 100);
		Array.print(a);
		
		DLinkedList<Long> llist = new DLinkedList<Long>();
		for (int i = 0; i < a.length; i++) {
			llist.addFirst(a[i]);
		}
		llist.display();
		llist.displayLast();
		
		
//		for (int i = 0; i < a.length + 5; i++) {
//			llist.removeFirst();
//		}
		
		
		long key = Utils.openInput();
		Link<Long> f = llist.find(key);
		Link<Long> d = llist.delete(key);
		
		System.out.println(f != null ? "find value: " + f.data : "not found");
		System.out.println(d != null ? "deleted: " + d.data : "not found");
		
		llist.display();
	}
	
	public void testLinkedList2() {
		long[] a = Utils.createArray(10, 100);
		Array.print(a);
		
		LinkedList<Long> llist = new LinkedList<Long>();
		for (int i = 0; i < a.length; i++) {
			llist.addFirst(a[i]);
		}
		llist.display();
		
		
		for (int i = 0; i < a.length + 5; i++) {
			llist.removeFirst();
		}
		
		
		long key = Utils.openInput();
		Link<Long> f = llist.find(key);
		Link<Long> d = llist.delete(key);
		
		System.out.println(f != null ? "find value: " + f.data : "not found");
		System.out.println(d != null ? "deleted: " + d.data : "not found");
		
		llist.display();
	}
	
	public void testLinkedList1() {
		long[] a = Utils.createArray(10, 100);
		Array.print(a);
		
		LinkedList<Long> llist = new LinkedList<Long>();
		for (int i = 0; i < a.length; i++) {
			llist.addFirst(a[i]);
		}
		llist.display();
		
		// for (int i = 0; i < a.length; i++) {
		for (int i = 0; i < 2; i++) {			
			llist.removeFirst();
		}
		
		
		long key = Utils.openInput();
		Link<Long> f = llist.find(key);
		Link<Long> d = llist.delete(key);
		
		System.out.println(f != null ? "find value: " + f.data : "not found");
		System.out.println(d != null ? "deleted: " + d.data : "not found");
		
		llist.display();
	}
	
	public void testExistQueue() {
		java.util.LinkedList<Long> llist = new java.util.LinkedList<Long>();
		long[] a = Utils.createArray(100, 1000);
		for (int i = 0; i < a.length; i++) {
			llist.add(a[i]);
		}
	}
	
	public static void main(String args[]) {
		new testLinkedList().start();
	}
}
