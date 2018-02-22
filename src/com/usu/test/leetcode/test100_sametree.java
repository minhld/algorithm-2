package com.usu.test.leetcode;

import com.usu.structs.news.LinkedList;

public class test100_sametree extends Thread {
	public void run() {
		
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public boolean isSameTree(TreeNode t1, TreeNode t2) {
        String q1 = getQueue(t1);
        String q2 = getQueue(t2);
        
        System.out.println(q1 + "\r\n" + q2);
        
        return q1.equals(q2);
    }
    
    private String getQueue(TreeNode t) {
        if (t == null) return "";
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        String res = "";
        
        queue.add(t);
        
        while (queue.size() > 0) {
            TreeNode n = queue.poll();
            
            if (n == null) {
                res += "null ";
                continue;
            }
            
            res += n.val + " ";
            
            if (n.left != null && n.right != null) {
                queue.add(n.left);
                queue.add(n.right);
            } else if (n.left == null && n.right != null) {
                queue.add(null);
                queue.add(n.right);
            } else if (n.left != null && n.right == null) {
                queue.add(n.left);
            } 
        }
        
        return res;
    }
    
	public static void main(String args[]) {
		new test100_sametree().start();
	}
}
