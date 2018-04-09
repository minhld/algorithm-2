package com.usu.test.leetcode;

public class test42_traprain extends Thread {
	
	public void run() {
		int[] h = new int[] { 3, 2, 5 };
		System.out.println(trap(h));
	}
	
	int trap(int[] height)
	{
	    int ans = 0;
	    int size = height.length;
	    for (int i = 1; i < size - 1; i++) {
	        int max_left = 0, max_right = 0;
	        for (int j = i; j >= 0; j--) { //Search the left part for max bar size
	            max_left = Math.max(max_left, height[j]);
	        }
	        for (int j = i; j < size; j++) { //Search the right part for max bar size
	            max_right = Math.max(max_right, height[j]);
	        }
	        ans += Math.min(max_left, max_right) - height[i];
	    }
	    return ans;
	}
	
	public static void main(String[] args) {
		new test42_traprain().start();
	}
}
