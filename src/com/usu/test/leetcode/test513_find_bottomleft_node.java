package com.usu.test.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.usu.structs.news.TreeNode;

public class test513_find_bottomleft_node {
	public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> list = levelOrder(root);
        
        List<Integer> lastList = list.get(list.size() - 1);
        
        return lastList.get(0);
    }
    
    List<List<Integer>> levelOrder(TreeNode root) {
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
