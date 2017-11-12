package com.usu.sorts.complex;

/**
 * use only 2 arrays to store temporary and final results
 * (to save spaces - O(N))
 * 
 * @author lee
 *
 */
public class SavedMergeSort {
	static long[] m;
	static long cCount = 0;
	static long sCount = 0;

	public static long[] sort(long[] a) {
		// create an array to temporarily store sorted data
		m = new long[a.length];
		
		long st = System.nanoTime();
		sort(a, 0, a.length - 1);
		double d = (System.nanoTime() - st) / 1000;
		System.out.println("[merge] compare: " + cCount + ", swap: " + sCount + " in " + d + "�s");
		return a;
	}
	
	public static void sort(long[] a, int min, int max) {
		if (min == max) {
			return;
		} 
		
		int mid = (min + max) / 2;
		sort(a, min, mid);
		sort(a, mid + 1, max);
		merge(a, min, mid, max);
	}
	
	/**
	 * merge two pieces of the array
	 * 
	 * @param a
	 * @param min
	 * @param mid
	 * @param max
	 * @return
	 */
	private static void merge(long[] a, int min, int mid, int max) {
		int idx1 = min, idx2 = mid + 1, idx = min;
		
		// pick the consecutively smallest item from two arrays
		while (idx1 <= mid && idx2 <= max) {
			m[idx++] = a[idx1] <= a[idx2] ? a[idx1++] : a[idx2++];
		}
		
		// add the remain items from the list #1 if there are
		while (idx1 < a.length) {
			m[idx++] = a[idx1++];
		}

		// add the remain items from the list #2 if there are
		while (idx2 < a.length) {
			m[idx++] = a[idx2++];
		}
		
		// return to the original array
		for (int i = min; i <= max; i++) {
			a[i] = m[i];
		}
	}
}
