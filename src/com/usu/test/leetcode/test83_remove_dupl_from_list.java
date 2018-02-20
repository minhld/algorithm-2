package com.usu.test.leetcode;

import com.usu.structs.HashMap;

public class test83_remove_dupl_from_list extends Thread {
	public void run() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(2);
		
		display(head);
		
		ListNode head1 = deleteDuplicates(head);
		
		display(head1);
	}
	
	private void display(ListNode h) {
		ListNode c = h;
		while (c != null) {
			System.out.print(c.val + " ");
			c = c.next;
		}
		System.out.println();
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
                // deleteNode(p, c);
            	p.next = c.next;
                c = p;
            }
            
            // go to the next node
            p = c;
            c = c.next;
        }  
        
        return head;
    }
    
//    private void deleteNode(ListNode p, ListNode c) {
//        p.next = c.next;
//        c = p;
//    }
	
	public static void main(String[] args) {
		new test83_remove_dupl_from_list().start();
	}
}
