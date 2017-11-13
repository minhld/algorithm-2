package com.usu.sorts.complex;

public class MergeSort {
	static long cCount = 0;
	static long sCount = 0;

	public static long[] sort(long[] a) {
		long st = System.nanoTime();
		long[] m = sort(a, 0, a.length - 1);
		double d = (System.nanoTime() - st) / 1000;
		System.out.println("[merge] compare: " + cCount + ", swap: " + sCount + " in " + d + "µs");
		return m;
	}
	
	public static long[] sort(long[] a, int min, int max) {
		if (min == max) {
			return new long[] { a[min] };
		} 
		
		int mid = (min + max) / 2;
		long[] d1 = sort(a, min, mid);
		long[] d2 = sort(a, mid + 1, max);
		return merge(d1, d2);
	}
	
	/**
	 * merge two array
	 * 
	 * @param a1
	 * @param a2
	 * @return
	 */
	private static long[] merge(long[] a1, long[] a2) {
		long[] d = new long[a1.length + a2.length];
		int idx1 = 0, idx2 = 0, idx = 0;
		
		// pick the consecutively smallest item from two arrays
		while (idx1 < a1.length && idx2 < a2.length) {
			d[idx++] = a1[idx1] <= a2[idx2] ? a1[idx1++] : a2[idx2++];
			cCount++;
			sCount++;
		}
		
		// add the remain items from the list #1 if there are
		while (idx1 < a1.length) {
			d[idx++] = a1[idx1++];
			sCount++;
		}

		// add the remain items from the list #2 if there are
		while (idx2 < a2.length) {
			d[idx++] = a2[idx2++];
			sCount++;
		}

		return d;
	}
}
