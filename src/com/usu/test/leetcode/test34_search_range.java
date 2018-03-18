package com.usu.test.leetcode;

public class test34_search_range {
	public int[] searchRange(int[] nums, int target) {
        int[] range = new int[] { -1, -1 };
        
        int low = 0, high = nums.length - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (nums[mid] == target) {
                int bef = mid - 1, aft = mid + 1;
                while (bef >= 0 && nums[bef] == target) {
                    bef--;
                }
                
                range[0] = bef + 1;
                
                while (aft < nums.length && nums[aft] == target) {
                    aft++;
                }
                
                range[1] = aft - 1;
                return range; 
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        
        // return the default range
        return range;
    }
}
