package com.usu.test.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.usu.structs.news.TreeNode;

public class test257_bin_tree_path {
	public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        return getPaths(root, "");
    }
    
    List<String> getPaths(TreeNode n, String p) {
        List<String> list = new ArrayList<>();
        
        if (n == null) return null;
        
        if (n != null && n.left == null && n.right == null) {
            p += "->" + n.val;
            p = p.indexOf("->") == 0 ? p.substring(2) : p;
            list.add(p);
            return list;
        }
        
        // else
        
        p += "->" + n.val;
        
        if (n.left != null) {
            List<String> subList = getPaths(n.left, p);
            list.addAll(subList);
        }
        
        if (n.right != null) {
            List<String> subList = getPaths(n.right, p);
            list.addAll(subList);
        }
        
        return list;
    }
}
