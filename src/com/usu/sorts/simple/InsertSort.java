package com.usu.sorts.simple;

public class InsertSort {
	public static long[] sort(long[] a) {
		long mark;
		int swPos = -1;
		long cCount = 0;
		long sCount = 0;
		
		long st = System.nanoTime();
		for (int i = 1; i < a.length; i++) {
			mark = a[i];
			swPos = i - 1;
			while (swPos >= 0 && mark < a[swPos]) {
				cCount++;
				// move bigger item to the right
				a[swPos + 1] = a[swPos--];
				sCount++;
			}

			// swap here
			a[swPos + 1] = mark;
			sCount++;
		}
		double d = (System.nanoTime() - st) / 1000;
		
		System.out.println("[insert] compare: " + cCount + ", swap: " + sCount + " in " + d + "µs");
		return a;
	}
}
