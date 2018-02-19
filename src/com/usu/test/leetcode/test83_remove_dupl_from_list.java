package com.usu.test.leetcode;

import com.usu.structs.HashMap;
import com.usu.structs.LinkedList;

public class test83_remove_dupl_from_list extends Thread {
	public void run() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(2);
		
		ListNode head1 = deleteDuplicates(head);
		
	}
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer, Integer> valueMap = new HashMap<>();
        
        // previous node
        ListNode p = null;
        
        // current node
        ListNode c = head;
        
        while (c != null) {
            if (!valueMap.containsKey(c.val)) {
                valueMap.put(c.val, c.val);
            } else {
                deleteNode(p, c);
            }
            
            // go to the next node
            p = c;
            c = c.next;
        }  
        
        return head;
    }
    
    private void deleteNode(ListNode p, ListNode c) {
        p.next = c.next;
        c = p;
    }
	
	public static void main(String[] args) {
		new test83_remove_dupl_from_list().start();
	}
}
