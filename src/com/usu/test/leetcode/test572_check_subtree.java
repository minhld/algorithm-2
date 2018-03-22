package com.usu.test.leetcode;

import com.usu.structs.news.TreeNode;

public class test572_check_subtree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;    // subtree not found
        
        if (s.val == t.val) {
            boolean isMatch = compareTree(s, t);
            if (!isMatch) {
                // if doesn't match
                boolean checkLeftChild = isSubtree(s.left, t);
                boolean checkRightChild = isSubtree(s.right, t);
                return checkLeftChild || checkRightChild;
            } else {
                return true;    // match
            }
        } else {
            boolean checkLeftChild = isSubtree(s.left, t);
            boolean checkRightChild = isSubtree(s.right, t);
            return checkLeftChild || checkRightChild;
        }
    }
    
    boolean compareTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;    // null is fine
        
        if (a == null || b == null) return false;   // doesn't match
        
        if (a.val == b.val) {
            boolean checkLeftChild = compareTree(a.left, b.left);
            boolean checkRightChild = compareTree(a.right, b.right);
            return checkLeftChild && checkRightChild;
        } else {
            return false;   // not match
        } 
    }
}
