package com.usu.test.dp;

public class test7_mindiff_partition_subsets extends Thread {
	public void run() {
		int[] a = new int[] { 3, 1, 4, 2, 2, 1 };
		System.out.println("res: " + findMin(a));
	}
	
	public int findMin(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return findMinRec(a, a.length - 1, 0, sum);
	}
	
	public int findMinRec(int[] a, int i, int subSum, int sum) {
		if (i == 0) {
			int sub = Math.abs(sum - 2 * subSum);
			System.out.println("sub res: " + sub);
			return sub;
		}
		
		return Math.min(findMinRec(a, i - 1, subSum + a[i], sum), 
						findMinRec(a, i - 1, subSum, sum));
	}
	
	public static void main(String args[]) {
		new test7_mindiff_partition_subsets().start();
	}
}
