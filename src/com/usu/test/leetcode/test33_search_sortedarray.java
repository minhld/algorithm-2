package com.usu.test.leetcode;

import com.usu.structs.news.Array;

public class test33_search_sortedarray extends Thread {
	public void run() {
		// int[] a = new int[] { 8,9,10,11,12,13,15,19, 1,2,3,5 };
		int[] a = new int[] { 1, 3, 5 };
		Array.print(a);
		
		System.out.println(search(a, 1));
	}
	
	public int search(int[] nums, int target) {
        int low = 0; 
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            // found it
            if (nums[mid] == target) return mid;
            
            if (nums[low] > nums[mid]) {
                // if mid pass the pivot to the right
                if (target >= nums[low] || target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // if mid is at the left of pivot
            	if (target >= nums[mid] || target <= nums[high]) {
                    if (target < nums[mid]) {
                    	high = mid - 1;
                    } else {
                    	low = mid + 1;
                    }
                } else {
                    high = mid - 1;
                }
            }
        }
        
        // not found
        return -1;
    }
	
	public static void main(String args[]) {
		new test33_search_sortedarray().start();
	}
}
