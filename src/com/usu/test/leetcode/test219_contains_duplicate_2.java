package com.usu.test.leetcode;

import com.usu.structs.HashMap;

public class test219_contains_duplicate_2 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int pos = map.get(nums[i]);
                if (i - pos <= k) return true;
            }
            
            // update each number and its position
            map.put(nums[i], i);
        }
        
        return false;
    }
    
    /*
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;
        
        for (int i = 0; i < nums.length; i++) {
            int j = i - k >= 0 ? i - k : 0;
            while (j < i) {
                if (nums[j] == nums[i]) {
                    return true;
                } else {
                    j++;
                }
            }
        }
        
        return false;
    }
    */
}
