package com.usu.sorts.complex;

import com.usu.structs.Heap;
import com.usu.structs.Heap.HeapType;

public class HeapSort {
	static long cCount = 0;
	static long sCount = 0;

	public static long[] sort(long[] a) {
		long st = System.nanoTime();
		
		Heap<Long> heap = new Heap<Long>(Long.class, HeapType.increase, a.length);
		for (int i = 0; i < a.length; i++) {
			heap.add(a[i]);
		}
		
		long[] m = new long[heap.size()];
		Long t;
		int c = 0;
		while ((t = heap.poll()) != null) {
			m[c++] = t;
		}
		
		double d = (System.nanoTime() - st) / 1000;
		System.out.println("[heap] compare: " + cCount + ", swap: " + sCount + " in " + d + "�s");
		return m;
	}
	
}
