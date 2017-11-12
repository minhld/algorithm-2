package com.usu.structs.test;

import com.usu.sorts.complex.MergeSort;
import com.usu.sorts.simple.BubbleSort;
import com.usu.sorts.simple.InsertSort;
import com.usu.sorts.simple.SelectionSort;
import com.usu.structs.Array;
import com.usu.structs.OrderedArray;
import com.usu.test.utils.Utils;

public class testArray extends Thread {
	public void run() {
		// testNormalArray();
		// testOrderedArray();
		// testBubbleSort();
		// testSelectionSort();
		testAllSorts();
	}
	
	public void testAllSorts() {
		long[] a1 = createArray(100, 1000);
		long[] a2 = copyArray(a1);
		long[] a3 = copyArray(a1);
		long[] a6 = copyArray(a1);
		long[] a7 = copyArray(a1);
		long[] a8 = copyArray(a1);
		
		BubbleSort.sort(a1);
		SelectionSort.sort(a2);
		long[] a13 = InsertSort.sort(a3);
		long[] a16 = MergeSort.sort(a6);
//		Array.print(BubbleSort.sort(a1));
//		Array.print(SelectionSort.sort(a2));
//		Array.print(InsertSort.sort(a3));
		Array.print(a13);
		Array.print(a16);
	}
	
	public void testSelectionSort() {
		long[] a = new long[50]; 
		for (int i = 0; i < a.length; i++) {
			long rand = (int)(Math.random() * 100);
			a[i] = rand;
		}
		a = SelectionSort.sort(a);
		Array.print(a);
	}
	
	public void testBubbleSort() {
		long[] a = new long[50]; 
		for (int i = 0; i < a.length; i++) {
			long rand = (int)(Math.random() * 100);
			a[i] = rand;
		}
		a = BubbleSort.sort(a);
		Array.print(a);
	}
	
	public void testOrderedArray() {
		OrderedArray a = new OrderedArray(15);
		for (int i = 0; i < 16; i++) {
			long rand = (int)(Math.random() * 100);
			a.insert(rand);
		}
		a.print();
		
		int key = Utils.openInput();
		System.out.println("find key [" + key + "]: at index " + a.find(key));
		// a.print();
	}
	
	public void testNormalArray() {
		Array a = new Array(14);
		for (int i = 0; i < 15; i++) {
			long rand = (int)(Math.random() * 100);
			a.insert(rand);
		}
		a.print();
		
		int val = Utils.openInput();
		System.out.println("attempting to delete " + a.delete(val));
		a.print();
	}
	
	/**
	 * copy array from an existed array
	 * 
	 * @param s
	 * @return
	 */
	private long[] copyArray(long[] s) {
		long[] d = new long[s.length];
		for (int i = 0; i < s.length; i++) {
			d[i] = s[i];
		}
		return d;
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
		new testArray().start();
	}
}
