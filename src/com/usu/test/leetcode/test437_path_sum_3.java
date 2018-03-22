package com.usu.test.leetcode;

import com.usu.structs.HashMap;
import com.usu.structs.news.TreeNode;

public class test437_path_sum_3 {
	HashMap<Integer, Integer> hash = new HashMap<>();
    
    public int pathSum(TreeNode root, int sum) {
        getAllSubPaths(root);
        return hash.containsKey(sum) ? hash.get(sum) : 0;
    }
    
    void getAllSubPaths(TreeNode n) {
        if (n == null) return;
        getPaths(n, 0);
        getAllSubPaths(n.left);
        getAllSubPaths(n.right);
    }
    
    void getPaths(TreeNode n, int sum) {
        if (n == null) return;
        
        if (n != null && n.left == null && n.right == null) {
            sum += n.val;
            add2Hash(sum);
        }
        
        // else
        sum += n.val;
        
        if (n != null && (n.left != null || n.right != null)) {
            add2Hash(sum);
        }
        
        if (n.left != null) {
            getPaths(n.left, sum);
        }
        
        if (n.right != null) {
            getPaths(n.right, sum);
        }
    }
    
    void add2Hash(int sum) {
        if (hash.containsKey(sum)) {
            int total = hash.get(sum);
            hash.put(sum, total + 1);
        } else {
            hash.put(sum, 1);
        }
    }
}
