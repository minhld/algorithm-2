package com.usu.test.ctci;

/**
 * LeetCode 98:
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * @author minhld
 *
 */
public class test2_string_expression extends Thread {
	public void run() {
		float r = solve("x + 8 + x + 3 = 4 - x");
		System.out.println("result: " + r);
	}
	
	private float solve(String s) {
		int sum = 0, esum = 0;
		s = s.replaceAll(" ", "");
		
		int equalPos = s.indexOf('=');
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (i < equalPos && isNumber(c)) {
				if (i == 0 || s.charAt(i - 1) == '+') {
					sum -= Integer.parseInt(String.valueOf(c));
				} else if (s.charAt(i - 1) == '-') {
					sum += Integer.parseInt(String.valueOf(c));
				}
			} else if (i > equalPos && isNumber(c)) {
				sum += (s.charAt(i - 1) == '+' || s.charAt(i - 1) == '=' ? 1 : -1) * Integer.parseInt(String.valueOf(c));
			} else if (i < equalPos && !isNumber(c)) {
				if (i == 0 || s.charAt(i - 1) == '+') {
					esum += 1;
				} else if (s.charAt(i - 1) == '-') {
					esum -= 1;
				}
			} else if (i > equalPos && isParam(c)) {
				esum += (s.charAt(i - 1) == '+' || s.charAt(i - 1) == '=' ? -1 : 1);
			}
		}
		return ((float) sum / (float) esum);
	}
	
	private boolean isParam(char c) {
		int v = (int)c;
		// c should not be either number or operator
		return (v >= 48 && v <= 57) || (c != '+' && c != '-' && c != '*' && c != '/');
	}
	
	private boolean isNumber(char c) {
		int v = (int)c;
		return v >= 48 && v <= 57;
	}
	
	public static void main(String args[]) {
		new test2_string_expression().start();
	}
}
