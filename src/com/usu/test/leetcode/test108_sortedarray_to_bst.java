package com.usu.test.leetcode;

import com.usu.structs.news.TreeNode;

public class test108_sortedarray_to_bst {
	
	public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }
    
    TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) return null;
        
        int mid = (left + right) / 2;

        TreeNode n = new TreeNode(nums[mid]);
        n.left = buildTree(nums, left, mid - 1);
        n.right = buildTree(nums, mid + 1, right);
        
        return n;
    }
}
