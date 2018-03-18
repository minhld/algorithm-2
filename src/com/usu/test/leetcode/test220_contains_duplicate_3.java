package com.usu.test.leetcode;

import java.util.HashMap;

public class test220_contains_duplicate_3 extends Thread {
	public void run() {
		int[] a = new int[] { 4, 2 };
		int k = 2;
		int t = 1;
				
		System.out.println(containsNearbyAlmostDuplicate(a, k, t));
	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k == 0 || t < 0) return false;
        
        HashMap<Long, Long> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucketKey = remappedNum / ((long) t + 1);     
            
            // search for the adjacent values
            if (map.containsKey(bucketKey) ||
                (map.containsKey(bucketKey - 1) && remappedNum - map.get(bucketKey - 1) <= t) || 
                (map.containsKey(bucketKey + 1) && map.get(bucketKey + 1) - remappedNum <= t)) {
                return true;
            }
            
            // keep the size of bucket list to not exceed k
            if (map.size() >= k) {
                long lastBucketKey = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucketKey);
            }
            
            map.put(bucketKey, remappedNum);
        }
        
        return false;
	}
	
	/*
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 0) return false;
        
        for (int i = 0; i < nums.length; i++) {
            int j = i - k >= 0 ? i - k : 0;
            while (j < i) {
                if (Math.abs((long) nums[j] - (long) nums[i]) <= t) {
                    return true;
                } else {
                    j++;
                }
            }
        }
        
        return false;
    }
	*/
	
	public static void main(String[] args) {
		new test220_contains_duplicate_3().start();
	}
}
