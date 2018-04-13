package com.usu.test.leetcode;

import com.usu.structs.news.TreeNode;

public class test671_second_min_nodes {
	public int findSecondMinimumValue(TreeNode root) {
        return findSecondMinimumValue(root, root.val);
    }
    
    public int findSecondMinimumValue(TreeNode root, int val) {
        // if tree doesn't have any child
        if (root.left == null && root.right == null) {
            return root.val > val ? root.val : -1;
        }
        
        if (root.left.val > root.val && root.right.val > root.val) {
            return Math.min(root.left.val, root.right.val);
        } else {
            int minLeft = findSecondMinimumValue(root.left, val);
            int minRight = findSecondMinimumValue(root.right, val);
            
            if (minLeft == -1) return minRight;
            if (minRight == -1) return minLeft;
            
            return Math.min(minLeft, minRight);
        }
        // return -1;
    }
}
