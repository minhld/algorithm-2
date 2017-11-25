package com.usu.structs;

public class Array {
	long[] array = null;
	int nElems = 0;
	int maxLength = 0;
	
	public Array(int max) {
		maxLength = max;
		array = new long[maxLength];
	}
	
	public boolean insert(long val) {
		// check if array is full
		if (nElems == maxLength) return false;
		array[nElems++] = val;
		return true;
	}
	
	public boolean delete(long val) {
		int i = 0;
		// find the index to delete
		for (; i < nElems; i++) {
			if (array[i] == val) break;
		}
		
		// can't find the value
		if (i == nElems) return false;
		
		// move higher ones down
		for (int j = i; j < nElems - 1; j++) {
			array[j] = array[j + 1];
		}
		nElems--;
		return true;
	}
	
	public int length() {
		return nElems;
	}
	
	public void print() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(array[i] + (i < nElems - 1 ? " " : ""));
		}
		System.out.println();
	}
	
	/**
	 * print any integer array 
	 * @param a
	 */
	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + (i < a.length - 1 ? " " : ""));
		}
		System.out.println();
	}
	
	/**
	 * print any array
	 * @param a
	 */
	public static void print(long[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + (i < a.length - 1 ? " " : ""));
		}
		System.out.println();
	}
}
