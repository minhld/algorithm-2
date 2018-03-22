package com.usu.test.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.usu.structs.news.ListNode;
import com.usu.structs.news.TreeNode;

/**
 * refer to {@link test108_sortedarray_to_bst} 
 * 
 * @author Minh Le
 *
 */
public class test109_sortedlinkedlist_2bst {
	public TreeNode sortedListToBST(ListNode<Integer> head) {
        int[] sortedArray = list2Array(head);
        return sortedArrayToBST(sortedArray);
    }
    
    int[] list2Array(ListNode head) {
        List<Integer> list = new ArrayList<>();
        
        while (head != null) {
            list.add((Integer) head.val);
            head = head.next;
        }
        
        int[] rets = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            rets[i] = list.get(i);
        }
        
        return rets;
    }
    
    TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }
    
    TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) return null;
        
        int mid = (left + right) / 2;

        TreeNode n = new TreeNode(nums[mid]);
        n.left = buildTree(nums, left, mid - 1);
        n.right = buildTree(nums, mid + 1, right);
        
        return n;
    }
}
