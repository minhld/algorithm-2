package com.usu.test.dp;

public class test3_longIncrease extends Thread {
	public void run() {
		// int[] a = new int[] { 5, 3, 7, 8, 1, 9, 2, 12, 11, 15, 21, 18 };
		int[] a = new int[] { 4,10,4,3,8,9 };
		int res = findLongestIncreaseSubArray(a);
		System.out.println("res: " + res);
	}
	
	private int findLongestIncreaseSubArray(int[] a) {
		int[] maxs = new int[a.length];
		maxs[0] = 1;
		
		for (int i = 1; i < a.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (a[i] > a[j]) {
					maxs[i] = Math.max(maxs[j] + 1, maxs[i]);
				} else {
					maxs[i] = 1;
				}
			}
		}
		
		return maxs[a.length - 1];
	}
	
	private void findLongestIncreaseSubArray2(int[] a) {
		int[] maxs = new int[a.length];
		maxs[0] = 0;
		
		for (int i = 1; i < a.length; i++) {
			maxs[i] = a[i - 1] <= a[i] ? maxs[i - 1] + 1 : maxs[i - 1];
			System.out.println("max increasing sequence at " + i + ": " + maxs[i]);
		}
		
		// System.out.println(maxs[a.length - 1]);
	}
	
	public static void main(String args[]) {
		new test3_longIncrease().start();
	}
}
