package com.usu.test.ctci;

import java.util.Iterator;

public class test79_circulararray extends Thread {
	
	public static void main(String args[]) {
		new test79_circulararray().start();
	}
	
	public void run() {
		CircularArray<Integer> ca = new CircularArray<Integer>(100);
		ca.set(0, 1);
		ca.set(1, 5);
		ca.set(2, 2);
		ca.set(3, 7);
		ca.set(4, 3);
		ca.set(5, 6);
		for (Integer i : ca) {
			System.out.println("item " + i);
		}
	}
	
	@SuppressWarnings("unchecked")
	public class CircularArray<T> implements Iterable<T> {
		T[] list;
		int head = 0;
		
		public CircularArray(int max) {
			list = (T[]) new Object[max];
		}
		
		public int convert(int index) {
			while (index < 0) {
				index += list.length;
			}
			return (head + index) % list.length; 
		}
		
		public void rotate(int shiftLen) {
			head = convert(shiftLen);
		}
		
		public T get(int i) {
			return list[convert(i)];
		}
		
		public void set(int i, T val) {
			list[convert(i)] = val;
		}
		
		public int size() {
			return list.length;
		}

		@Override
		public Iterator<T> iterator() {
			return new CircularArrayIterator(this);
		}
		
		public class CircularArrayIterator implements Iterator<T> {
			CircularArray<T> array;
			int index;
			
			public CircularArrayIterator(CircularArray<T> a) {
				array = a;
				index = 0;
			}
			
			@Override
			public boolean hasNext() {
				return (index < array.size());
			}

			@Override
			public T next() {
				return array.get(index++);
			}
			
		}
		
	}
}
