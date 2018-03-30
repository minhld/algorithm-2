package com.usu.structs.news;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) {
		val = x; 
	}
	
	@Override
	public String toString() {
		return "val: " + val + ", " + 
			   "left: " + (left != null ? left.val : "null") + ", " +
			   "right: " + (right != null ? right.val : "null") + ", ";
	}
}
