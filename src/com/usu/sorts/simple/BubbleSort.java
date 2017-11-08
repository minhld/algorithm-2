package com.usu.sorts.simple;

/**
 * simplest sort - complexity is O(N^2)
 * 
 * @author minhld
 *
 */
public class BubbleSort {
	public static long[] sort(long[] a) {
		long sw;
		long cCount = 0;
		long sCount = 0;
		
		long st = System.nanoTime();
		for (int i = a.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				cCount++;
				if (a[j] > a[j + 1]) {
					sw = a[j];
					a[j] = a[j + 1];
					a[j + 1] = sw;
					sCount++;
				}
			}
		}
		long d = (System.nanoTime() - st) / 1000;

		System.out.println("[bubble] compare: " + cCount + ", swap: " + sCount + " in " + d + "µs");
		return a;
	}
}
