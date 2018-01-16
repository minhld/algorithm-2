package com.usu.test.leetcode;

import com.usu.structs.Stack;

public class test25_swapnodes_m {
	/**
	 * Definition for singly-linked list.
	*/ 
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		Stack<ListNode> stack = new Stack<>();
		ListNode newHead = null;

		ListNode c = head; // current node
		ListNode n = null; // new current node
		ListNode p = null; // prev node in the stack
		ListNode l = null; // the last item of the array listed by the stack
		int size = 0, count = 0; // size of the list
		int sizeNow = 0;
		boolean foundHead = false; // flag that set when new head is found

		// check if k is less than size of the list
		while (c != null) {
			size++;
			c = c.next;
		}
		if (k > size)
			return head;

		c = head; // reset the pointer
		while (c != null) {
			// if the rest of the list has less item number than k
			// then just skip
			if (sizeNow > size - k) {
				l.next = c;
				break;
			}

			// try to add k items to the stack
			while (c != null && count < k) {
				// find the current item of the stack
				p = !stack.isEmpty() ? stack.peek() : null;
				stack.push(c);
				n = c;
				c = c.next;

				// connect the current item to the previous one in the stack
				// make it a reverse connect
				n.next = p;

				count++;
				sizeNow++;
			}

			// try to remove k items out of the stack
			int i = 0;
			while (i < count) {
				n = stack.pop();
				// connect the last item of the last stack to the first item
				// of the next stack
				if (i == 0 && l != null)
					l.next = n;
				i++;

				// assign the head - only assign once
				if (!foundHead) {
					newHead = n;
					foundHead = true;
				}
			}

			// store the last item of the current stack, will connect it to
			// the first item of the next stack (line 36)
			l = n;

			count = 0; // reset the counter
		}

		return newHead;
	}
}
