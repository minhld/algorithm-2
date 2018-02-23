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
        
        // level - 0
        queue.add(root);
      
        int itemsOfLastLevel = 1;           // number of items at the previous level
        int itemsOfLevel = 0;               // number of items at the current level
        String line = "";
        
        int step = 0;
        while (queue.size() > 0) {
            TreeNode n = queue.poll();
            step++;
            

            line += (n != null ? n.val : "x") + " ";
            if (step == itemsOfLastLevel) {
                boolean lineOK = isStringSymmetric(line);
                System.out.println(line + ": " + lineOK + ", " + itemsOfLevel + ", " + itemsOfLastLevel);
                // if (!lineOK) return false;

                // reset the counters
                line = "";
                itemsOfLastLevel = itemsOfLevel * 2;
                itemsOfLevel = 0;
                step = 0;
            }

            if (n == null) continue;

            if (n.left != null || n.right != null) {
                queue.add(n.left);
                if (n.left != null) itemsOfLevel++;
                
                queue.add(n.right);
                if (n.right != null) itemsOfLevel++;
            }
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
