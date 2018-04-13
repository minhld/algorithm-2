package com.usu.test.leetcode;

public class test670_maxswap {
	public int maximumSwap(int num) {
        String numStr = String.valueOf(num);
        for (int i = 0; i < numStr.length(); i++) {
            numStr = maximumSwap(numStr, i);
            if (Integer.valueOf(numStr) > num) {
                return Integer.valueOf(numStr);
            }
        }
        return num;
    }
    
    String maximumSwap(String num, int i) {
        int c = Integer.valueOf(num.charAt(i));
        
        int n, max = 0, maxIdx = -1;
        char[] nums = num.toCharArray();
        
        for (int j = i; j < nums.length; j++) {
            n = Integer.valueOf(nums[j]);
            if (n >= max) {
                max = n;
                maxIdx = j;
            }
        }
        
        if (max > c) {
            char t = nums[maxIdx];
            nums[maxIdx] = nums[i];
            nums[i] = t;
        }
        return new String(nums);
    }
}
