package com.usu.test.leetcode;

import com.usu.structs.Stack;
import com.usu.structs.news.TreeNode;

public class test112_pathsum {
	public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        
        if (root == null) return false;
        
        // int cSum = 0;
        while (!st.isEmpty()) {
            TreeNode n = st.pop();
            // cSum += n.val;
            
            System.out.println(n.val);
            
            if (n.left == null && n.right == null) {
                
                if (n.val == sum) {
                    return true;
                } else {
                    System.out.println(n.val);
                    continue;
                    
                }
            } else {
                if (n.left != null) {
                    n.left.val += n.val;
                    st.push(n.left);
                }
                if (n.right != null) {
                    n.right.val += n.val;
                    st.push(n.right);
                }
            }
        }
        
        return false;
    }
}
