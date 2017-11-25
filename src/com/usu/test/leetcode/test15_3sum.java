package com.usu.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.usu.structs.Array;
import com.usu.structs.HashMap;

public class test15_3sum extends Thread {
	public void run() {
		
		// int[] nums = new int[] { 1, 0, -1, 2, 1, -1, 2, 4};
		// int[] nums = new int[] { -1,0,1,2,-1,-4 };
		int[] nums = new int[] { 0, 0, 0, 0 };
		threeSum(nums);
	}
	
	public static void main(String args[]) {
		new test15_3sum().start();
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        // sort the array in increasing order - O(nlogn)
        Arrays.sort(nums);
        
        // hashmap for distinguishing array of the lists of the two items
        java.util.HashMap<String, int[]> disHash = new java.util.HashMap<>();
        String b;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                b = Integer.toString(nums[i]) + Integer.toString(nums[j]);
                if (!disHash.containsKey(b)) {
                    // save the positions of the set of items
                    disHash.put(b, new int[] { i, j });
                }
            }
        }
        
        int[] aSet;
        java.util.HashMap<String, int[]> disHash2 = new java.util.HashMap<>();
        List<Integer> subList;
        for (String key : disHash.keySet()) {
            aSet = disHash.get(key);
            for (int i = aSet[1] + 1; i < nums.length; i++) {
                if (nums[aSet[0]] + nums[aSet[1]] + nums[i] == 0) {
                    b = key + Integer.toString(nums[i]);
                    if (!disHash2.containsKey(b)) {
                        subList = new ArrayList<>();
                        subList.add(nums[aSet[0]]);
                        subList.add(nums[aSet[1]]);
                        subList.add(nums[i]);
                        list.add(subList);
                    }
                }
            }
        }
        
        return list;
	}
}
