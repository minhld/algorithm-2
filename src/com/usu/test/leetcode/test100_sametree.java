package com.usu.test.leetcode;

import com.usu.structs.news.LinkedList;
import com.usu.structs.news.TreeNode;

public class test100_sametree extends Thread {
	public void run() {
		
	}
	
	public boolean isSameTree(TreeNode t1, TreeNode t2) {
        LinkedList<Integer> q1 = getQueue(t1);
        LinkedList<Integer> q2 = getQueue(t2);
        
        while (q1.size() > 0) {
            if (q1.poll() != q2.poll()) {
                return false;
            }
        }
        
        return true;
    }
    
    private LinkedList<Integer> getQueue(TreeNode t) {
        LinkedList<Integer> queue = new LinkedList<>();
        
        return queue;
    }
    
	public static void main(String args[]) {
		new test100_sametree().start();
	}
}
