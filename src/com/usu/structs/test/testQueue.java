package com.usu.structs.test;

import com.usu.structs.Array;
import com.usu.structs.LinkQueue;
import com.usu.structs.PriorityQueue;
import com.usu.structs.Queue;

public class testQueue extends Thread {
	public void run() {
		// testExistQueue();
		// testAllQueue();
		// testPriorityQueue();
		testLinkQueue();
	}
	
	public void testLinkQueue() {
		long[] a = createArray(100, 1000);
		Array.print(a);
		
		LinkQueue<Long> pQueue = new LinkQueue<>();
		for (int i = 0; i < a.length; i++) {
			boolean f = pQueue.add(a[i]);
			if (!f) {
				System.out.println("item #" + i + " with value " + a[i] + " cannot be added");
			}
		}
		LinkQueue.print(pQueue);
	}
	
	public void testPriorityQueue() {
		long[] a = createArray(100, 1000);
		Array.print(a);
		
		PriorityQueue<Long> pQueue = new PriorityQueue<>(Long.class, 18);
		for (int i = 0; i < a.length; i++) {
			boolean f = pQueue.add(a[i]);
			if (!f) {
				System.out.println("item #" + i + " with value " + a[i] + " cannot be added");
			}
		}
		Queue.print(pQueue);
	}
	
	public void testAllQueue() {
		long[] a = createArray(10, 1000);
		Array.print(a);
		
		Queue<Long> queue = new Queue<>(Long.class, 18);
		for (int i = 0; i < a.length; i++) {
			boolean f = queue.add(a[i]);
			if (!f) {
				System.out.println("item #" + i + " with value " + a[i] + " cannot be added");
			}
		}
		
		Long l;
		for (int i = 0; i < a.length + 3; i++) {
			System.out.print(((l = queue.poll()) != null ? l : "void") + " ");
		}
		System.out.println();
		queue.add(100000l);
		
		Queue.print(queue);
	}
	
	public void testExistQueue() {
		java.util.Queue<Long> queue = new java.util.LinkedList<Long>();
		long[] a = createArray(100, 1000);
		for (int i = 0; i < a.length; i++) {
			queue.add(a[i]);
		}
	}
	
	/**
	 * create an array with random values
	 * 
	 * @param size
	 * @param range
	 * @return
	 */
	private long[] createArray(int size, int range) {
		long[] a = new long[size]; 
		for (int i = 0; i < a.length; i++) {
			long rand = (long)(Math.random() * range);
			a[i] = rand;
		}
		return a;
	}
	
	public static void main(String args[]) {
		new testQueue().start();
	}
}
