package com.usu.test.leetcode;

import com.usu.structs.Array;

public class test31_next_permutation extends Thread {
	public void run() {
		int[] a = new int[] { 1, 3, 2, 5, 4 };
		nextPermutation(a);
		Array.print(a);
	}
	
	public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len <= 1) return;
        
        int temp;
        
        for (int i = len - 1; i >=1; i--) {
            if (nums[i] > nums[i - 1]) {
                
                // find the swap pos
                int j = len - 1;
                while (nums[j] <= nums[i - 1]) {
                    j--;
                }
                
                swap(nums, j, i - 1);
                
                rotate(nums, i, len - 1);
                
                // end the search
                return;
            }
        } 
        
        // when there is no permutation found
        rotate(nums, 0, len - 1);
    }

    private void rotate(int[] nums, int start, int end) {
        int len = (end - start) / 2;
        for (int i = start; i <= start + len; i++) {
            swap(nums, i, end - (i - start));
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

	
	public static void main(String args[]) {
		new test31_next_permutation().start();
	}
}
