package com.usu.sorts.complex;

public class ShellSort {
	static long cCount = 0;
	static long sCount = 0;

	public static long[] sort(long[] a) {
		int gap = findLargestGap(a.length);
		
		long st = System.nanoTime();
		while (gap >= 1) {
			sort(a, gap);
			gap = (gap - 1) / 3;
		}
		double d = (System.nanoTime() - st) / 1000;
		System.out.println("[shell] compare: " + cCount + ", swap: " + sCount + " in " + d + "µs");
		
		return a;
	}
	
	/**
	 * sort in an array created by items distanced by a gap
	 * 
	 * @param a
	 * @param gap
	 */
	private static void sort(long[] a, int gap) {
		int idx, pIdx;
		int numInGap = a.length / gap + 1;
		long temp;
		
		for (int i = 0; i < gap; i++) {
			for (int j = 0; j < numInGap && i + gap * j < a.length; j++) {
				idx = i + gap * j;
				pIdx = i + gap * (j - 1);
				temp = a[idx];
				while (pIdx >= 0 && temp < a[pIdx]) {
					a[idx] = a[pIdx];
					idx = pIdx;
					pIdx = pIdx - gap;
				}
				a[idx] = temp;
			}
		}
	}
	
	/**
	 * find the last possible gap by array's length 
	 * 
	 * @param size
	 * @return
	 */
	private static int findLargestGap(int size) {
		int gap = 0;
		while (3 * gap + 1 < size) {
			gap = 3 * gap + 1;
		}
		return gap;
	}
}
