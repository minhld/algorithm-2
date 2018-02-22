package com.usu.test.leetcode;

public class test53_max_subarray {
	public int maxSubArray(int[] nums) {
        if (nums.length == 0) return Integer.MIN_VALUE;
        
        int[] max = new int[nums.length];
        max[0] = nums[0];
        
        int maxSub = max[0];
        
        for (int i = 1; i < nums.length; i++) {
            max[i] = max(max[i - 1] + nums[i], nums[i]);
            maxSub = max(maxSub, max[i]);
        }
        return maxSub;
    }
    
    private int max(int a, int b) {
        return a > b ? a : b;
    }
}
