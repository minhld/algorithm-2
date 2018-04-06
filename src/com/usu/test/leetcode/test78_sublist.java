package com.usu.test.leetcode;

import java.util.ArrayList;
import java.util.List;

public class test78_sublist extends Thread {
	public void run() {
		int[] a = new int[] { 1, 2, 3 };
		List<List<Integer>> res = subsets(a);
		
		for (int i = 0; i < res.size(); i++) {
			for (int j : res.get(i)) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	
	
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // add an empty list first
        list.add(new ArrayList<Integer>());

        if (nums.length == 0) return list;
        
        List<List<Integer>> newList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
        		newList.clear();
            for (int j = 0; j < list.size(); j++) {
                List<Integer> sub = new ArrayList<>(list.get(j));
                sub.add(nums[i]);
                newList.add(sub);
            }
            list.addAll(newList);
        }
        return list;
    }
	
	public static void main(String args[]) {
		new test78_sublist().start();
	}
}
