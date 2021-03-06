package com.usu.test.dp;

import java.util.Arrays;

public class test3_longIncrease extends Thread {
	public void run() {
		// int[] a = new int[] { 5, 3, 7, 8, 1, 9, 2, 12, 11, 15, 21, 18 };
		// int[] a = new int[] { 4,10,4,3,8,9 };
		int[] a = new int[] { 1,3,6,7,9,4,10,5,11 };
		// int[] a = new int[] { 1, 4, 2, 5, 3, 4 };
		int res = findLongestIncreaseSubArray3(a);
		System.out.println("res: " + res);
		
//		findLongestIncreaseSubArray2(a);
	}
	
	private int findLongestIncreaseSubArray3(int[] nums) {
		if (nums.length <= 1) return nums.length;
        
		int[] maxs = new int[nums.length];
		
		Arrays.fill(maxs, 1);
		
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && maxs[i] < maxs[j] + 1) {
					maxs[i] = maxs[j] + 1;
				}
			}
		}
		
		int max = 0; 
		for (int  i = 0; i < nums.length; i++) {
			System.out.print(maxs[i] + "  ");
            if (max < maxs[i])
            	max = maxs[i];
		}
		
		return maxs[nums.length - 1];
	}
	
	private int findLongestIncreaseSubArray(int[] a) {
		if (a.length <= 1) return a.length;
        
        int[] maxs = new int[a.length];
		maxs[0] = 1;
		
		boolean inc = false;
		for (int i = 1; i < a.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (a[i] > a[j]) {
					maxs[i] = Math.max(maxs[j] + 1, maxs[i]);
					inc = true;
					break;
				} else {
					maxs[i] = Math.max(maxs[j], maxs[i]);
				}
			}
			if (!inc) {
				maxs[i] = 1;
			}
			inc = false;
		}
		
        int max = 0;
        for (int i = 0; i < maxs.length; i++) {
            max = Math.max(max, maxs[i]);
        }
		return max;
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
