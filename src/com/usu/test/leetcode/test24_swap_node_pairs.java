package com.usu.test.leetcode;

public class test24_swap_node_pairs extends Thread {
	public void run() {
		
	}
	
	public static void main(String args[]) {
		new test24_swap_node_pairs().start();
	}
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode swapPairs(ListNode head) {
		ListNode h, p, f, l;
        h = head;
        p = h;
        f = h;
        l = f.next;
        
        if (l == null) return head;
        
        if (l != null) {
            head = l;
        }
        
        while (l != null) {
            // rotate
            if (p != head) {
                
            }
            f.next = l.next;
            l.next = f;
            
            // move next
            f = f.next;
            l = f.next;
        }
        
        return head;
	}
}
