package com.usu.structs;

public class OrderedArray extends Array {

	public OrderedArray(int max) {
		super(max);
	}
	
	public boolean insert(long val) {
		// array is full
		if (nElems == maxLength) return false;
		
		// move larger number to the right
		int i = nElems - 1;
		while (i >= 0 && array[i] >= val) {
			array[i + 1] = array[i];
			i--;
		}
		array[i + 1] = val;
		nElems++;
		return true;
	}
}
