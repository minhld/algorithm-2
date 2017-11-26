package com.usu.test.leetcode;

import java.util.Arrays;

public class test16_3sum_min extends Thread {
public void run() {
		
		int[] nums = new int[] { 1, 1, 1, 1 };
		int target = 4;
		long startTime = System.nanoTime();
		int sum = threeSumClosest(nums, target);
		System.out.println("out: " + sum + " in " + (System.nanoTime() - startTime) / 1000);
	}
	
	public static void main(String args[]) {
		new test16_3sum_min().start();
	}
	
	public int threeSumClosest(int[] nums, int target) {

        // sort list
        Arrays.sort(nums);
        
        int j, k, sum, rSum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            j = i + 1;
            k = nums.length - 1;
            while (j < k) {
            	sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                } else {
                	if (min > Math.abs(sum - target)) {
                		min = Math.abs(sum - target);
                		rSum = sum;
                	}
                	
                	// move the cursors to the better position
                    if (sum > target) k--;
                    else j++;
                }
            }
        }
        
        return rSum;
    }
}
