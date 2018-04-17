package com.usu.test.leetcode;

public class test136_single_num {
	/* help from discussion
     * using XOR for different bits will return 1 while same bits return 0
     * example: A ^ B ^ A = B
     */
    
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
