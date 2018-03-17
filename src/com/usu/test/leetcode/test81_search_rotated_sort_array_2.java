package com.usu.test.leetcode;

import com.usu.structs.news.Array;

/**
 * refer to @link {@link test33_search_sortedarray}
 * 
 * @author minhle
 *
 */
public class test81_search_rotated_sort_array_2 extends Thread {
	public void run() {
		int[] a = new int[] { 1, 1, 1, 3, 1 };
		// int[] a = new int[] { 1, 2, 2, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		
		Array.print(a);
		
		System.out.println(search(a, 3));
	}
	
	
	public boolean search(int[] nums, int target) {
        int low = 0; 
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            // found it
            if (nums[mid] == target) return true;

            if (nums[low] == nums[mid]) {
            		low++;
            } else if (nums[low] < nums[mid]) {
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
        
        return false;
    }
	
	public static void main(String[] args) {
		new test81_search_rotated_sort_array_2().start();
	}
}
