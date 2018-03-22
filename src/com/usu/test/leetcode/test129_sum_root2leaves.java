package com.usu.test.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.usu.structs.news.TreeNode;

public class test129_sum_root2leaves {
	
	public int sumNumbers(TreeNode root) {
        String[] paths = getPath(root, "");
        
        long sum = 0;
        for (String p : paths) {
            System.out.println(p);
            long val = !p.equals("") && p.indexOf("x") < 0 ? Long.parseLong(p) : 0;
            sum += val;
        }
        
        return (int) sum;
    }
    
    String[] getPath(TreeNode n, String s) {
        if (n == null) return new String[] { s + "x" };
        
        if (n != null && n.left == null && n.right == null) {
            return new String[] { s + n.val };
        }
        
        List<String> list = new ArrayList<>();
        
        String[] leftPaths = getPath(n.left, s + n.val);
        
        for (String p : leftPaths) {
            list.add(p);
        }
        
        String[] rightPaths = getPath(n.right, s + n.val);
        
        for (String p : rightPaths) {
            list.add(p);
        }
        
        return list.toArray(new String[] {});
    }
}
