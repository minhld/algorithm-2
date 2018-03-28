package com.usu.test.leetcode;

public class test213_house_robber_2 extends Thread {
	public void run() {
		int[] a = new int[] {3,1,1,2,1,5,2,4};
		int maxVal = rob(a);
		System.out.println("max val: " + maxVal);
	}
	
	public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        return Math.max(
            rob(nums, 0, nums.length - 2),
            rob(nums, 1, nums.length - 1));
    }
    
    int rob(int[] nums, int start, int end) {
        if (start > end) return 0;
        if (start == end) return nums[start];
        
        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
        	int j = i - start;
            dp[j] = Math.max(dp[j - 2] + nums[j], dp[j - 1]);
        }
        
        return dp[dp.length - 1];
    }
	
	public static void main(String args[]) {
		new test213_house_robber_2().start();
	}
}
