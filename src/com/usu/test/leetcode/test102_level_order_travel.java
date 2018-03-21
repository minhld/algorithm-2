package com.usu.test.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class test102_level_order_travel {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        
        // empty tree
        if (root == null) return list;
        
        // queue
        LinkedList<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        int remainNum = 1;
        
        // define the sub list
        List<Integer> subList = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            subList.add(n.val);
            
            if (n.left != null) {
                queue.add(n.left);
            }
            
            if (n.right != null) {
                queue.add(n.right);
            }

            // 
            remainNum--;
            
            // if the remaining number of queue is 0, add the current sub list to the 
            // main list and create a new sub list
            if (remainNum == 0) {
                remainNum = queue.size();
                list.add(subList);
                subList = new ArrayList<>();
            }
        }
        
        return list;
    }
}
