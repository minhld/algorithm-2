package com.usu.structs.test;

import com.usu.structs.Array;

public class testQueue extends Thread {
	public void run() {
		// testExistQueue();
		testAllQueue();
	}
	
	public void testAllQueue() {
		long[] a = createArray(20, 1000);
		Array.print(a);
		
	
		for (int i = 0; i < a.length; i++) {
			
		}
		
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
