package com.usu.test.leetcode;

public class test88_mergesortedarray extends Thread {
	public void run() {
		
	}
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = 0;
        // iterate through the nums2
        for (int i = 0; i < n; i++) {
            while (pos < m) {
                if (nums2[i] > nums1[pos]) {
                    pos++;
                } else {
                    break;
                }
            }
            // found, then insert
            insert(nums1, m++, nums2[i], pos++);
        }
    }
    
    private void insert(int[] nums1, int m, int val, int pos) {
        int i = m;
        while (i > pos) {
            nums1[i] = nums1[i - 1];
            i--;
        }
        nums1[pos] = val;
    }
	
	public static void main(String args[]) {
		new test88_mergesortedarray().start();
	}
}
