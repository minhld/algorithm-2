package com.usu.structs.test;

import java.util.ArrayList;
import java.util.List;

public class testSparseVector extends Thread {
	class SparseVector {
		int[] data;
		List<Integer> idxList = new ArrayList<>();
		
		public SparseVector(int[] a) {
			this.data = a;
			for (int i = 0; i < a.length; i++) {
				if (a[i] != 0) {
					idxList.add(i);
				}
			}
		}
	}
	
	public int dotProduct(int[] a, int[] b) {
		return dotProduct(new SparseVector(a), new SparseVector(b));
	}
	
	public int dotProduct(SparseVector a, SparseVector b) {
		int aIdx = 0, bIdx = 0, idx = -1;
		int sum = 0;
		while (aIdx < a.idxList.size()) {
			if (a.idxList.get(aIdx) == b.idxList.get(bIdx)) {
				idx = a.idxList.get(aIdx);
				sum += a.data[idx] * b.data[idx];
				aIdx++;
				bIdx++;
			} else if (a.idxList.get(aIdx) > b.idxList.get(bIdx)) {
				bIdx++;
			} else {
				aIdx++;
			}
		}
		return sum;
	}
	
	public void run() {
		int[] a = { 0, 1, 1, 2, 0, 0, 0 , 5, 0, 0, 1 };
		int[] b = { 0, 1, 0, -1, 3, 2, 0, -2, 1, 3, 5  };
		
		System.out.println("res: " + dotProduct(a, b));
	}
	
	public static void main(String args[]) {
		new testSparseVector().start();
	}
	
}
