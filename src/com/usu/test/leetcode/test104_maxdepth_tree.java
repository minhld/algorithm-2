package com.usu.test.leetcode;

public class test104_maxdepth_tree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int maxDepth(TreeNode root) {
        return getHeight(root);
    }
    
    private int getHeight(TreeNode n) {
		if (n == null) return 0;
		return Math.max(getHeight(n.left), getHeight(n.right)) + 1;
	}
}
