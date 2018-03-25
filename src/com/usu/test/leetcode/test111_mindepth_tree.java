package com.usu.test.leetcode;

public class test111_mindepth_tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public int minDepth(TreeNode root) {
        return getMinHeight(root);
    }
    
    private int getMinHeight(TreeNode n) {
		if (n == null) return 0;
        
        int leftHeight = getMinHeight(n.left) + 1;
        int rightHeight = getMinHeight(n.right) + 1;
        
        if (leftHeight > 1 && rightHeight > 1) {
            return Math.min(leftHeight, rightHeight);
        } else {
            // only has left branch
            if (leftHeight > 1) return leftHeight;
            
            // only has right branch
            if (rightHeight > 1) return rightHeight;
            
            // if only root node is available
            return 1;
        }
	}
}
