package com.usu.test.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class test18_4sum extends Thread {
	public void run() {
		int[] nums = new int[] { -1, 0, -1, 2, -2, 3, 1, 0 };
		int target = 0;
		long startTime = System.nanoTime();
		List<List<Integer>> output = fourSum(nums, target);
		System.out.println("total: " + (System.nanoTime() - startTime) / 1000);
	}
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new LinkedList<>();
        Set<List<Integer>> disList = new HashSet<>();
        List<Integer> sub;
        
        Arrays.sort(nums);
        
        int k, l, sum;
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                k = j + 1;
                l = nums.length - 1;
                while (k < l) {
                    sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum - target == 0) {
                        sub = new LinkedList<>();
                        sub.add(nums[i]);
                        sub.add(nums[j]);
                        sub.add(nums[k]);
                        sub.add(nums[l]);
                        disList.add(sub);
                        k++;
                    } else if (sum - target > 0) {
                        l--;
                    } else if (sum - target < 0) {
                        k++;
                    }
                }
            }
        }
        
        list.addAll(disList);
        return list;
        
    }
	
	public static void main(String args[]) {
		new test18_4sum().start();
	}
}
