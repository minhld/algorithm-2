package com.usu.test.dp;

/**
 * find the minimum number of coins a1, a2, .., an to have
 * a sum value S
 * 
 * @author minhld
 *
 */
public class test2_sum extends Thread {
	public void run() {
		int[] a = new int[] { 1, 3, 5 };
		int S = 11;
		findMinCoinNumber(a, S);
	}
	
	private void findMinCoinNumber(int a[], int S) {
		int[] mins = new int[S];
		for (int i = 0; i < mins.length; i++) {
			mins[i] = 10000;
		}
		mins[0] = 0;
		
		for (int i = 1; i < S; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[j] <= i && mins[i - a[j]] + 1 < mins[i]) {
					mins[i] = mins[i - a[j]] + 1;
				}
			}
			System.out.println("min number of coins for value " + i + ": " + mins[i]);
		}
	}
	
	public static void main(String args[]) {
		new test2_sum().start();
	}
}
