package com.usu.structs;

import java.lang.reflect.Array;

public class Stack<T> {
	T[] array;
	int top = -1;
	
	@SuppressWarnings("unchecked")
	public Stack(Class<T> c, int max) {
		array = (T[]) Array.newInstance(c, max);
	}
	
	public T push(T val) {
		// stack is full
		if (top == array.length - 1) return null;
		
		// push into the stack
		array[++top] = val;
		return val;
	}
	
	public T pop() {
		// stack is empty
		if (top == -1) return null;
		return array[top--];
	}
	
	public T peek() {
		return array[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public int size() {
		return top + 1;
	}
	
	/**
	 * this will flush out the entire stack
	 */
	public static <T> void print(Stack<T> s) {
		while (!s.isEmpty()) {
			T e = s.pop();
			System.out.print(e + " ");
		}
	}
}
