package com.usu.sorts.complex;

public class RadixSort {
	static long cCount = 0;
	static long sCount = 0;

	public static long[] sort(long[] a) {
		long st = System.nanoTime();
		sort(a, 0, a.length - 1);
		long d = (System.nanoTime() - st) / 1000;
		System.out.println("[quick] compare: " + cCount + ", swap: " + sCount + " in " + d + "µs");
		return a;
	}
	
	private static void sort(long[] a, int left, int right) {
		if (left >= right) return;
		else {
			long pivot = findBestPivot(a, left, right); // a[right];
			int pPos = partition(a, left, right, pivot);
			sort(a, left, pPos - 1);
			sort(a, pPos + 1, right);
		}
	}
	
	public static int partition(long[] a, int left, int right, long pivot) {
		int leftPtr = left;
		int rightPtr = right - 1;
		
		while (true) {
			// move left cursor to the right
			while (leftPtr <= right && a[leftPtr] < pivot) {
				leftPtr++;
				cCount++;
			}
			
			// move right cursor to the left
			while (rightPtr >= left && a[rightPtr] > pivot) {
				rightPtr--;
				cCount++;
			}
			
			if (leftPtr >= rightPtr) {
				break;
			} else {
				swap(a, leftPtr++, rightPtr--);
				sCount++;
			}
		}
		swap(a, leftPtr, right);
		return leftPtr--;
	}
	
	private static long findBestPivot(long[] a, int left, int right) {
		int center = (left + right) / 2;
		
		// order left & center
		if (a[left] > a[center])
			swap(a, left, center);
		
		// order left & right
		if (a[left] > a[right])
			swap(a, left, right);
		
		// order center & right
		if (a[center] > a[right])
			swap(a, center, right);
		
		// put pivot on right
		swap(a, center, right);
		
		return a[right]; 
	}
	
	private static void swap(long[] a, int i, int j) {
		long t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
