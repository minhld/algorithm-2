package com.usu.structs.test;

import com.usu.structs.Array;
import com.usu.structs.LinkedList;
import com.usu.structs.PriorityQueue;
import com.usu.structs.Queue;
import com.usu.test.utils.Utils;

public class testLinkedList extends Thread {
	public void run() {
		testLinkedList1();
	}
	
	public void testLinkedList1() {
		long[] a = Utils.createArray(10, 100);
		Array.print(a);
		
		LinkedList<Long> llist = new LinkedList<Long>();
		for (int i = 0; i < a.length; i++) {
			llist.addFirst(a[i]);
		}
		llist.display();
		
		
		llist.removeFirst();
		llist.removeFirst();
		
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
