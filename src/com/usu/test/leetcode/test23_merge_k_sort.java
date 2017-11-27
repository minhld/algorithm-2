package com.usu.test.leetcode;

/**
 * Merge k sorted linked lists and return it as one sorted list. 
 * Analyze and describe its complexity.
 * 
 * @author mac
 *
 */
public class test23_merge_k_sort extends Thread {
	public void run() {
		
	}
	
	public static void main(String args[]) {
		new test23_merge_k_sort().start();
	}
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	 
	public ListNode mergeKLists(ListNode[] cs) {
        ListNode f = null, c = null;
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        
        if (cs.length == 0) {
            return f;
        }
        
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] != null && min > cs[i].val) {
                min = cs[i].val;
                minIdx = i;
            }
        }
        
        if (minIdx >= 0) {
            f = cs[minIdx];
            c = f;
            cs[minIdx] = cs[minIdx].next;
            c.next = mergeKLists(cs);
        }
        
        return f;
    }
}
