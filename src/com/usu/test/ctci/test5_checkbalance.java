package com.usu.test.ctci;

import com.usu.structs.tree.Node;
import com.usu.structs.tree.Tree;

public class test5_checkbalance extends Thread {
	public void run() {
		Tree<Integer> t = new Tree<>();
		
		// buildTree1(t);
		
		// buildTree2(t);
		
		buildTree3(t);
		
		t.display();
		
		System.out.println("tree (height " + getHeight(t.root) + ") balanced: " + checkBalance(t.root));
	}
	
	/**
	 * check if the tree is balanced at a node
	 * 
	 * @param n
	 * @return
	 */
	boolean checkBalance(Node<Integer> n) {
		if (n == null) return true;
		
		boolean heightDiff = Math.abs(getHeight(n.left) - getHeight(n.right)) <= 1;
		
		boolean isChildrenBalanced = checkBalance(n.left) && checkBalance(n.right); 
		
		return heightDiff && isChildrenBalanced;
	}
	
	private int getHeight(Node<Integer> n) {
		if (n == null) return 0;
		return Math.max(getHeight(n.left), getHeight(n.right)) + 1;
	}
	
	void buildTree1(Tree<Integer> t) {
		t.insert(20, 20);
		t.insert(15, 15);
		t.insert(18, 18);
		t.insert(21, 21);
		t.insert(11, 11);
		t.insert(8, 8);
		t.insert(12, 12);
		t.insert(14, 14);
		t.insert(5, 5);
		t.insert(10, 10);
		t.insert(16, 16);
		t.insert(19, 19);
//		t.insert(30, 30);
//		t.insert(22, 22);
//		t.insert(32, 32);
	}
	
	void buildTree2(Tree<Integer> t) {
		t.insert(12, 12);
		t.insert(9, 9);
		t.insert(18, 18);
		t.insert(5, 5);
		t.insert(10, 10);
		t.insert(15, 15);
		t.insert(21, 21);
		t.insert(3, 3);
		t.insert(6, 6);
		t.insert(11, 11);
		t.insert(19, 19);
	}
	
	void buildTree3(Tree<Integer> t) {
		t.insert(1, 1);
		t.insert(2, 2);
	}
	
	public static void main(String args[]) {
		new test5_checkbalance().start();
	}
}
