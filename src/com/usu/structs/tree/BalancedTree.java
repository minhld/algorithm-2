package com.usu.structs.tree;

/**
 * balanced by AVL 
 *  - the sub-trees of every node differ in height by at most one
 *  - every sub-tree is an AVL tree
 *  
 * @author lee
 *
 * @param <T>
 */
public class BalancedTree<T> extends Tree<T> {
	@Override
	public boolean insert(int key, T data) {
		// insert the node -> tree may be unbalanced
		super.insert(key, data);
		rotateLeft();
		rotateRight();
		return true;
	}
	
	private Node<T> rotateLeft() {
		return null;
	}
	
	private Node<T> rotateRight() {
		return null;
	}
}
