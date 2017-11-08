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
	
	/**
	 * [binary search] search item by key and return item's index 
	 * if found otherwise return -1 
	 * 
	 * @param key
	 * @return
	 */
	public int find(long key) {
		int min = 0, max = nElems - 1;
		int mid = (min + max) / 2;
		
		while (min < max) {
			// item found
			if (key == array[mid]) return mid;
			
			if (key < array[mid]) {
				// go to the first half
				max = mid - 1;
			} else {
				// go to the second half
				min = mid + 1;
			}
			mid = (min + max) / 2;
		}
		
		
		// can't find
		return -1;
	}
}
