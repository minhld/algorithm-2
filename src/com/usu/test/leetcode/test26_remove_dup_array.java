package com.usu.test.leetcode;

public class test26_remove_dup_array {
	public int removeDuplicates(int[] nums) {
        int min = Integer.MIN_VALUE;
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (min < nums[i]) {
                min = nums[i];
                
                // store the distinct numbers in the same array
                // by overwriting from the index 0
                nums[size++] = min;
            }
        }
        return size;
    }
}
