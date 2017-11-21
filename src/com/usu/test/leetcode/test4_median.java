package com.usu.test.leetcode;

public class test4_median {
	/**
	 * find the median of two sorted arrays
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] s = new int[nums1.length + nums2.length];
        int i1 = 0, i2 = 0;
        for (int i = 0; i < s.length; i++) {
            if (i1 < nums1.length && i2 < nums2.length) {
                s[i] = nums1[i1] < nums2[i2] ? nums1[i1++] : nums2[i2++];
            } else if (i1 < nums1.length) {
                s[i] = nums1[i1++];
            } else if (i2 < nums2.length) {
                s[i] = nums2[i2++];
            }
        }
        
        if (s.length % 2 == 1) {
            int m = (s.length - 1) / 2;
            return s[m];
        } else {
            int m = (int) Math.floor((s.length - 1) / 2);
            return ((double)s[m] + (double)s[m + 1]) / 2;
        }
    }
}
