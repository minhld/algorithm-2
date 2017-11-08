package com.usu.sorts.simple;

public class InsertSort {
	public static long[] sort(long[] a) {
		long min;
		int swPos = -1;
		long cCount = 0;
		long sCount = 0;
		long st = System.nanoTime();
		for (int i = 0; i < a.length - 1; i++) {
			min = a[i];
			for (int j = i + 1; j < a.length; j++) {
				cCount++;
				// find the minimum item to fill the dedicated left position
				if (min > a[j]) {
					min = a[j];
					swPos = j;
				}
			}
			
			// swap with the left position
			if (min < a[i]) {
				a[swPos] = a[i];
				a[i] = min;
				sCount++;
			}
		}
		double d = (System.nanoTime() - st) / 1000;
		
		System.out.println("[selection] compare: " + cCount + ", swap: " + sCount + " in " + d + "µs");
		return a;
	}
}
