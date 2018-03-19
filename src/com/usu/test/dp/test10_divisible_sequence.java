package com.usu.test.dp;

public class test10_divisible_sequence extends Thread {
	public void run() {
		// int[] a = new int[] { 1, 2, 3, 4, 6 };
		int[] a = new int[] { 1, 3, 9 };
		int m = 4;
		boolean res = isPossible2(a, m);
		System.out.println("RL result: " + res);
		
		res = isPossible3(a, m, 0, a[0]);
		System.out.println("RL2 result: " + res);
		
		res = isPossible(a, m);
		System.out.println("DP result: " + res);
	}

	public boolean isPossible(int[] a, int m) {
		
	}
	
	public boolean isPossible3(int[] a, int m, int i, int sum) {
		if (i == a.length - 1) {
			return sum % m == 0;
		}
		
		boolean i1 = isPossible3(a, m, i + 1, sum + a[i + 1]);
		
		boolean i2 = isPossible3(a, m, i + 1, sum - a[i + 1]);
		
		return i1 || i2;
	}
	
	/**
	 * if any combination could be divisible by m
	 * complexity: O(2^n)
	 * 
	 * use recursive loop
	 * 
	 * @param a
	 * @param m
	 * @return
	 */
	public boolean isPossible2(int[] a, int m) {
		int[] vals = eval(a, 0);
		
		boolean isPossible = false;
		for (int i = 0; i < vals.length; i++) {
			System.out.println(vals[i] + ": " + (vals[i] % m));
			if (!isPossible && vals[i] % m == 0) isPossible = true; 
		}
		return isPossible;
	}
	
	int[] eval(int[] a, int s) {
		if (s == a.length - 1) {
			return new int[] { a[s] };	// 1 item
		}
		
		int[] res = eval(a, s + 1);
		
		int[] newRes = new int[res.length * 2];
		for (int i = 0; i < res.length; i++) {
			newRes[i * 2] = a[s] + res[i];
			newRes[i * 2 + 1] = a[s] - res[i];
		}
		
		return newRes;
	}
	
	public static void main(String args[]) {
		new test10_divisible_sequence().start();
	}
}
