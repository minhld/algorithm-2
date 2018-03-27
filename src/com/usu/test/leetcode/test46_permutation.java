package com.usu.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test46_permutation extends Thread {
	public void run() {
		int[] a = new int[] { 1, 2, 3 };
		List<List<Integer>> list = permute(a);
		
		String s = "";
		for (List<Integer> l : list) {
			for (Integer i : l) {
				s += " " + i;
			}
			System.out.println(s);
			s = "";
		}
	}
	
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutes = subPermute(nums, new ArrayList<Integer>(), 0);
        return permutes;
    }
    
    private List<List<Integer>> subPermute(int[] nums, List<Integer> cur, int idx) {
        List<List<Integer>> list = new ArrayList<>();
            
        if (idx == nums.length - 1) {
            // find the last item that does not exist in the current list
            for (int i = 0; i < nums.length; i++) {
                if (!cur.contains(nums[i])) {
                    cur.add(nums[i]);
                    list.add(cur);
                    break;
                }
            }
            return list;
        }
        
        List<Integer> locCur;
        for (int i = 0; i < nums.length; i++) {
            if (!cur.contains(nums[i])) {
                locCur = new ArrayList<>(cur);
                locCur.add(nums[i]);
                List<List<Integer>> subList = subPermute(nums, locCur, idx + 1);
//                
//                for (List<Integer> l : subList) {
//                    locCur.addAll(l);
//                    list.add(locCur);
//                }
                
                list.addAll(subList);
            }
            
        }
        
        return list;
    }
	
	public static void main(String args[]) {
		new test46_permutation().start();
	}
}
