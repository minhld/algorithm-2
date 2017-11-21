package com.usu.structs.test;

import com.usu.structs.Array;
import com.usu.structs.Stack;
import com.usu.structs.ArrayStack;

public class testStack extends Thread {
	public void run() {
		// testExistStack();
		// testAllStack();
		testLinkedStack();
	}
	
	public void testLinkedStack() {
		long[] a = createArray(20, 1000);
		Array.print(a);
		
		Stack<Long> stack = new Stack<>();
		
		for (int i = 0; i < a.length; i++) {
			stack.push(a[i]);
		}
		Stack.print(stack);
	}
	
	public void testAllStack() {
		long[] a = createArray(20, 1000);
		Array.print(a);
		
		ArrayStack<Long> stack = new ArrayStack<>(Long.class, a.length);
		
		for (int i = 0; i < a.length; i++) {
			stack.push(a[i]);
		}
		ArrayStack.print(stack);
	}
	
	public void testExistStack() {
		java.util.Stack<Long> stack = new java.util.Stack<>();
		long[] a = createArray(100, 1000);
		for (int i = 0; i < a.length; i++) {
			stack.push(a[i]);
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
		new testStack().start();
	}
}
