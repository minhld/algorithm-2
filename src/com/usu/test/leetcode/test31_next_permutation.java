package com.usu.test.leetcode;

import com.usu.structs.Array;

public class test31_next_permutation extends Thread {
	public void run() {
		int[] a = new int[] { 1, 3, 5, 4, 2 };
		nextPermutation1(a);
		Array.print(a);
	}
	
	public void nextPermutation1(int[] nums) {
        // if length is just 1 or less
        if (nums.length <= 1) return;
        
        // if length is greater or equal 2
        boolean greaterPermFound = false;
        int temp = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                // swap the two numbers
                temp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = temp;
                greaterPermFound = true;
                break;
            }
        }
        
        // if no greater permutation found
        // sort them again by the reverse order
        if (!greaterPermFound) {
            for (int i = 0; i < nums.length / 2; i++) {
                temp = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = temp;
            }
        }
    }
	
	public static void main(String args[]) {
		new test31_next_permutation().start();
	}
}
