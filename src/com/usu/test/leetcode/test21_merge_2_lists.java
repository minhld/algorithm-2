package com.usu.test.leetcode;

/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes 
 * of the first two lists.
 * 
 * @author lee
 *
 */
public class test21_merge_2_lists {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = null, c = null;
        if (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l = l1;
                c = l;
                c.next = mergeTwoLists(l1.next, l2);
            } else {
                l = l2;
                c = l;
                c.next = mergeTwoLists(l1, l2.next);
            }
        } else if (l1 != null && l2 == null) {
            l = l1;
            c = l;
            c.next = mergeTwoLists(l1.next, l2);
        } else if (l1 == null && l2 != null) {
            l = l2;
            c = l;
            c.next = mergeTwoLists(l1, l2.next);
        } else {
            return l;
        }
        return l;
    }
}
