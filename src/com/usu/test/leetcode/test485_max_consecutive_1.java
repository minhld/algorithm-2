package com.usu.test.leetcode;

public class test485_max_consecutive_1 {
	public int findMaxConsecutiveOnes(int[] nums) {
        int maxLength = 0;
        
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                length++;
            } else {
                maxLength = Math.max(maxLength, length);
                length = 0;
            }
        }
        maxLength = Math.max(maxLength, length);
        return maxLength;
    }
}
