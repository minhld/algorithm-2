package com.usu.test.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import com.usu.structs.news.TreeNode;

public class test669_trim_Bst extends Thread {
	TreeNode mRoot;
	
	public void run() {
		String input = "[2,0,33,null,1,25,40,null,null,11,31,34,45,10,18,29,32,null,36,43,46,4,null,12,24,26,30,null,null,35,39,42,44,null,48,3,9,null,14,22,null,null,27,null,null,null,null,38,null,41,null,null,null,47,49,null,null,5,null,13,15,21,23,null,28,37,null,null,null,null,null,null,null,null,8,null,null,null,17,19,null,null,null,null,null,null,null,7,null,16,null,null,20,6]";
		TreeNode root = stringToTreeNode(input);
		
		mRoot = trimBST(root, 25, 26);
		
		System.out.println(root.val);
	}
	
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (L > R) return root;
        
        mRoot = root;
        
        trimLowBST(mRoot, null, L);
        
        trimHighBST(mRoot, null, R);
        
        return mRoot;
    }
    
    void trimLowBST(TreeNode curr, TreeNode prev, int L) {
        if (curr == null) return;
        
        // TRIM THE LOWER VALUES
        
        if (curr.val > L) {
            // travel to the left
            prev = curr;
            trimLowBST(curr.left, prev, L);
        } else if (curr.val == L) {
            // remove the left sub tree
            curr.left = null;
        } else {
            // curr.val < L -> replace current by the right child
            if (prev != null) {
                prev.left = curr.right;
            } else {
                mRoot = curr.right;
            }
            
            curr = curr.right;
            trimLowBST(curr, prev, L);
        }
    }
    
    void trimHighBST(TreeNode curr, TreeNode prev, int R) {    
        if (curr == null) return;
        
        // TRIM THE HIGHER VALUES
        
        if (curr.val < R) {
            // travel to the left
            prev = curr;
            trimHighBST(curr.right, prev, R);
        } else if (curr.val == R) {
            // remove the left sub tree
            curr.right = null;
        } else {
            // curr.val > R -> replace current by the left child
            if (prev != null) {
                prev.right = curr.left;
            } else {
                mRoot = curr.left;
            }
            curr = curr.left;
            trimHighBST(curr, prev, R);
        }
    }
    
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }
    
        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
    
        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
    
    public static void main(String args[]) {
		new test669_trim_Bst().start();
	}
}
