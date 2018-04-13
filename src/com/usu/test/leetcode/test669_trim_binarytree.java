package com.usu.test.leetcode;

import com.usu.structs.news.TreeNode;

public class test669_trim_binarytree {
	TreeNode r;
    
    public TreeNode trimBST(TreeNode root, int L, int R) {
        r = root;
        trimLeft(r, null, L);
        trimRight(r, null, R);
        return r;
    }
    
    public void trimRight(TreeNode root, TreeNode p, int R) {
        if (root == null) return;
        
        if (root.val == R) {
            root.right = null;
            return;
        }
        
        if (root.val < R) {
            trimRight(root.right, root, R);
        } else {
            if (p == null) {
                r = root.left;      // update root
                trimRight(root.left, p, R);
            } else {
                p.right = root.left;
                trimRight(root.left, p, R);
            }
        }
    }
    
    public void trimLeft(TreeNode root, TreeNode p, int L) {
        if (root == null) return;
        
        if (root.val == L) {
            root.left = null;
            return;
        }
        
        if (root.val > L) {
            trimLeft(root.left, root, L);
        } else {
            if (p == null) {
                r = root.right;      // update root
                trimLeft(root.right, p, L);
            } else {
                p.left = root.right;
                trimLeft(root.right, p, L);
            }
        }    
    }
}
