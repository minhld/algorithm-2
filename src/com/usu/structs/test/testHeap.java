package com.usu.structs.test;

import java.util.LinkedList;

import com.usu.structs.Heap;
import com.usu.structs.PriorityQueue;
import com.usu.test.utils.Utils;

public class testHeap extends Thread {
	public void run() {
		// testExistingHeap();
		testMyHeap();
	}
	
	public void testMyHeap() {
		long[] a = Utils.createArray(105, 1000);
		// PriorityQueue<Long> q = new PriorityQueue<>(Long.class, 100);
		Heap<Long> h = new Heap<>(Long.class, a.length);
		for (int i = 0; i < a.length; i++) {
			h.add(a[i]);
		}
		h.display();
	}
	
	public void testExistingHeap() {
		java.util.Queue<Long> q1 = new LinkedList<>();
				
		java.util.PriorityQueue<Long> q = new java.util.PriorityQueue<>();
		
		q.add(5l);
		q.add(3l);
		q.add(2l);
		q.add(9l);
		q.add(1l);
		
	
		Long l = q.poll();
		while (l != null) {
			System.out.print(l + " ");
			l = q.poll();
		}
		
//		for (int i = 0; i < q.size(); i++) {
//			System.out.print(q.poll() + " ");
//		}
	}
	
	public static void main(String args[]) {
		new testHeap().start();
	}
}
