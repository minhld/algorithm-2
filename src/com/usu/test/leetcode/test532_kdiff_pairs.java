package com.usu.test.leetcode;

import java.util.HashMap;

public class test532_kdiff_pairs {
	public int findPairs(int[] nums, int k) {
        int count = 0;
        
        // add numbers to the set O(n)
        HashMap<Integer, Integer> numMap = new HashMap<>();
        
        for (int n : nums) {
            int num = 0;
            if (numMap.containsKey(n)){
                num = numMap.get(n);
            }
            numMap.put(n, num + 1);
        }
        
        if (k == 0) {
            for (Integer i : numMap.keySet())
                if (numMap.get(i) > 1) count += 1;
        } else if (k > 0) {
            for (Integer i : numMap.keySet())
                if (numMap.containsKey(i + k)) count += 1;
        }
        
        return count;
    }
}
