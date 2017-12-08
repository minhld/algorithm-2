package com.usu.test.dp;

public class test8_distance_cover extends Thread {
	public static void main(String args[]) {
		new test8_distance_cover().start();
	}
	
	int total = 0;
	
	private int numOfWays(int val, int[] steps, int i) {
		if (i == steps.length - 1) {
			int res = (val % steps[i] == 0) ? 1 : 0;
			total += res;
			System.out.println("step " + steps[i] + ", v: " + val + ", res: " + res);
			return res; 
		}
		
		int count = val / steps[i];

		int sum = 0;
		for (int j = 0; j <= count; j++) {
			System.out.println("step " + steps[i] + ", i: " + j + ", val: " + (val - j * steps[i]));
			sum += numOfWays(val - j * steps[i], steps, i + 1);
		}
		
		return sum; 
	}
	
	public void run() {
		int val = 3;
		int[] steps = new int[] { 1, 2, 3 };
		System.out.println("res: " + numOfWays(val, steps, 0));
		System.out.println("res: " + total);
	}
}
