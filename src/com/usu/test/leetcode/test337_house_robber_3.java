package com.usu.test.leetcode;

import com.usu.structs.news.TreeNode;

public class test337_house_robber_3 extends Thread {
	/**
     * by suggestion in the discussion
     */
    public int rob(TreeNode root) {
        int[] maxVals = dpRob(root);
        return Math.max(maxVals[0], maxVals[1]);
    }
    
    /**
     * int[0] holds the sum counting the node n, 
     * int[1] holds the sum without counting the node n
     */ 
	int[] dpRob(TreeNode n) {
        if (n == null) return new int[] {0, 0};
        
        int[] maxVals = new int[2];
            
        int[] leftMax = dpRob(n.left);
        int[] rightMax = dpRob(n.right);
        
        maxVals[0] = leftMax[1] + rightMax[1] + n.val;
        maxVals[1] = Math.max(leftMax[0], leftMax[1]) + Math.max(rightMax[0], rightMax[1]);
        
        return maxVals;
    }
}
