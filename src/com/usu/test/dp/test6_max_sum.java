package com.usu.test.dp;

/**
 * Largest Sum Contiguous Subarray
 * 
 * @author minhld
 *
 */
public class test6_max_sum extends Thread {
	public void run() {
		// int[] a = new int[] { -2, -3, 4, -1, -2, -3, 5, -3 };
		int[] a = new int[] { 2, 3, 9, -2, 1 };
		System.out.println("result: " + max(a));
		System.out.println("result: " + max2(a, 0));
	}
	
	public int max2(int[] a, int idx) {
		int max = Integer.MIN_VALUE, emax;
		if (idx == a.length - 1) {
			max = Math.max(a[a.length - 1], max);
			return max;
		}
		
		emax = Math.max(a[idx] + max2(a, idx + 1), max2(a, idx + 1));
		max = Math.max(emax, max);
		
		return max;
	}
	
	/**
	 * using dynamic programming
	 *  
	 * @param a
	 * @return
	 */
	public int max(int[] a) {
		int[] maxs = new int[a.length];
		maxs[0] = a[0];
		int max = 0;
		
		for (int i = 1; i < maxs.length; i++) {
			maxs[i] = Math.max(a[i], a[i] + maxs[i - 1]);
			max = Math.max(maxs[i], max);
		}
		return max;
	}
	
	public static void main(String args[]) {
		new test6_max_sum().start();
	}
}
