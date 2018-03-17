package com.usu.test.leetcode;

import com.usu.structs.news.Array;

public class test33_search_sortedarray extends Thread {
	public void run() {
		// int[] a = new int[] { 8,9,10,11,12,13,15,19, 1,2,3,5 };
		// int[] a = new int[] { 3, 2 };
		int[] a = new int[] { 2, 4, 6, 8 };
		
		Array.print(a);
		
		System.out.println(search(a, 2));
	}
	
	public int search(int[] nums, int target) {
        int low = 0; 
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            // found it
            if (nums[mid] == target) return mid;

            if (nums[low] <= nums[mid]) {
            		// the mid is on the left side of the pivot
            		if (target >= nums[low] && target < nums[mid]) {
            			// target belongs to the left side of the pivot
            			high = mid - 1;
            		} else {
            			// target belongs to the right side of pivot
            			low = mid + 1;
            		}
            } else {
            		// the mid is on the right side of the pivot
            		if (target > nums[mid] && target <= nums[high]) {
            			low = mid + 1;
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
