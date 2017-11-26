package com.usu.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.usu.structs.Array;
import com.usu.structs.HashMap;

public class test15_3sum extends Thread {
	public void run() {
		
		// int[] nums = new int[] { 1, 0, -1, 2, 1, -1, 2, 4};
		int[] nums = new int[] { -1,0,1,2,-1,-4 };
		// int[] nums = new int[] { 0, 0, 0, 0 };
		long startTime = System.nanoTime();
		List<List<Integer>> outList1 = threeSum2(nums);
		System.out.println("arraylist: " + (System.nanoTime() - startTime) / 1000);
		
		startTime = System.nanoTime();
		List<List<Integer>> outList2 = threeSum3(nums);
		System.out.println("linkedlist: " + (System.nanoTime() - startTime) / 1000);
		
		startTime = System.nanoTime();
		List<List<Integer>> outList3 = threeSum(nums);
		System.out.println("hashmap: " + (System.nanoTime() - startTime) / 1000);
	}
	
	public static void main(String args[]) {
		new test15_3sum().start();
	}
	
	public List<List<Integer>> threeSum3(int[] nums) {
		if(nums == null || nums.length < 3) {
            return new ArrayList<>();
        } 
		long startTime = System.nanoTime();
        List<List<Integer>> mList = new LinkedList<>();
        System.out.println("linkedlist1: " + (System.nanoTime() - startTime) / 1000);
        
        Set<List<Integer>> list = new HashSet<>();
        
        // sort the array in increasing order - O(nlogn)
        Arrays.sort(nums);
        
        List<Integer> subList;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
            		startTime = System.nanoTime();
                    subList = new LinkedList<>();
                    subList.add(nums[i]);
                    subList.add(nums[j]);
                    subList.add(nums[k]);
                    list.add(subList);
                    System.out.println("linkedlist2: " + (System.nanoTime() - startTime) / 1000);
                    j++;
                } else if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                }
            }
        }
        
        mList.addAll(list);
        return mList;
	}
	
	public List<List<Integer>> threeSum2(int[] nums) {
		if(nums == null || nums.length < 3) {
            return new ArrayList<>();
        } 
		
		long startTime = System.nanoTime();
        List<List<Integer>> mList = new ArrayList<List<Integer>>();
        System.out.println("arraylist1: " + (System.nanoTime() - startTime) / 1000);

        Set<List<Integer>> list = new HashSet<>();
        
        // sort the array in increasing order - O(nlogn)
        Arrays.sort(nums);
        
        List<Integer> subList;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                	startTime = System.nanoTime();
                    subList = new ArrayList<>();
                    subList.add(nums[i]);
                    subList.add(nums[j]);
                    subList.add(nums[k]);
                    list.add(subList);
                    System.out.println("arraylist2: " + (System.nanoTime() - startTime) / 1000);
                    j++;
                } else if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                }
            }
        }
        
        mList.addAll(list);
        return mList;
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		long startTime = System.nanoTime();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		System.out.println("hashmap1: " + (System.nanoTime() - startTime) / 1000);
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
            		startTime = System.nanoTime();
                    disHash.put(b, new int[] { i, j });
                    System.out.println("hashmap2: " + (System.nanoTime() - startTime) / 1000);
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
                		startTime = System.nanoTime();
                        subList = new ArrayList<>();
                        subList.add(nums[aSet[0]]);
                        subList.add(nums[aSet[1]]);
                        subList.add(nums[i]);
                        list.add(subList);
                        System.out.println("hashmap3: " + (System.nanoTime() - startTime) / 1000);
                    }
                }
            }
        }
        
        return list;
	}
}
