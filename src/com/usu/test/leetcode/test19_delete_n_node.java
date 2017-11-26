package com.usu.test.leetcode;

import java.util.ArrayList;

public class test19_delete_n_node {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
        java.util.List<ListNode> list = new ArrayList<>();
        ListNode c = head;
        
        // find the tail and add to a list
        while (c != null && c.next != null) {
            list.add(c);
            c = c.next;
        }
        list.add(c);
        
        int delIdx = list.size() - n;
        
        if (delIdx == 0) {
            head = list.size() > 1 ? list.get(1) : null;
        } else {
            ListNode last = list.get(delIdx - 1);
            ListNode next = delIdx < list.size() - 1 ? list.get(delIdx + 1) : null;
            last.next = next;
        }
        
        return head;
    }
}
