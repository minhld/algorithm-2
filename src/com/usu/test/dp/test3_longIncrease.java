package com.usu.test.dp;

public class test3_longIncrease extends Thread {
	public void run() {
		int[] a = new int[] { 5, 3, 4, 8, 6, 7 };
		findLongestIncreaseSubArray(a);
	}
	
	private void findLongestIncreaseSubArray(int[] a) {
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
