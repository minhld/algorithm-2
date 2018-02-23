package com.usu.test.leetcode;

import com.usu.structs.news.LinkedList;
import com.usu.structs.news.TreeNode;

public class test101_symmetric_tree extends Thread {
	public void run() {
		String s = "6 x 6 x";
		
		System.out.println(isStringSymmetric(s));
	}
	
	public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        
        if (root == null) return true;
        
        queue.add(root);
      
        int size = 1;
        String line = "";
        
        while (true) {
            size = queue.size();
            if (size == 0) break;
            
            while (--size >= 0) {
                TreeNode c = queue.poll();
                
                line += (c != null ? c.val : "x") + " ";
                
                if (c != null) {
                    queue.add(c.left);
                    queue.add(c.right);
                }
            }
            
            boolean lineOK = isStringSymmetric(line);
            System.out.println(line + ": " + lineOK);
            line = "";
            if (!lineOK) return false;
        }
        
        return true;
    }
    
    private boolean isStringSymmetric(String s) {
        String[] subs = s.split(" ");
        
        int len = subs.length;
        
        for (int i = 0; i < len / 2; i++) {
            if (!subs[i].equals(subs[len - i - 1])) {
                return false;
            }
        }
        return true;
    }
	
	public static void main(String args[]) {
		new test101_symmetric_tree().start();
	}
}
