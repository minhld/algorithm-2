package com.usu.structs.tree;

import com.usu.structs.LinkQueue;

public class Tree<T> {
	Node<T> root;
	
	public Node<T> find(int key) {
		Node<T> c = root;
		
		while(c.key != key) {
			if (c.key < key) {
				c = c.right;
			} else {
				c = c.left;
			}
		}
		return c;
	}
	
	public boolean insert(int key, T data) {
		Node<T> n = new Node<T>(key, data);
		Node<T> c = root;
		
		if (root == null) {
			root = n;
			return true;
		}
		
		Node<T> p = null;
		boolean isOnLeft = false;
		while (c != null && c.key != key) {
			p = c;
			if (c.key > key) {
				c = c.left;
				isOnLeft = true;
			} else {
				c = c.right;
				isOnLeft = false;
			}
		}
		
		// duplicated key will be omitted
		if (c != null && c.key == key) return false;
		
		if (isOnLeft) {
			p.left = n;
		} else {
			p.right = n;
		}
		return true;
	}
	
	public boolean delete(int key) {
		Node<T> p = null;
		Node<T> c = root;
		
		boolean isOnLeft = false;
		while(c != null && c.key != key) {
			p = c;
			if (c.key > key) {
				c = c.left;
				isOnLeft = true;
			} else {
				c = c.right;
				isOnLeft = false;
			}
		}
		
		// key found
		if (c != null) {
			if (c.left == null && c.right == null) {
				// if deleted node doesn't have any children
				if (p != null) {
					if (isOnLeft) {
						p.left = null;
					} else {
						p.right = null;
					}
				} else {
					// c is root
					root = null;
				}
			} else if (c.left != null && c.right != null) {
				// if deleted node has two children
				Node<T> s = findSuccessor(c);
				s.left = c.left;
				s.right = c.right;
				if (p != null) { 
					if (isOnLeft) {
						p.left = s;
					} else {
						p.right = s;
					}
				} else {
					root = s;
				}
			} else {
				if (p != null) {
					// if deleted node has only one child
					if (isOnLeft) {
						p.left = c.left != null ? c.left : c.right;
					} else {
						p.right = c.left != null ? c.left : c.right;;
					}
				} else {
					// deleted note is root
					root = c.left != null ? c.left : c.right;
				}
			}
		}
		
		// key not found or other reasons
		return false;
	}

	/**
	 * find the successor node of the deleted node <b>c</b> 
	 * 
	 * @param c
	 * @return
	 */
	private Node<T> findSuccessor(Node<T> c) {
		boolean isOnLeft = false;
		Node<T> p = c;
		c = c.right;
		
		while (c.left != null) {
			p = c;
			c = c.left;
			isOnLeft = true;
		}
		
		// remove the successor and replace by its right child
		if (isOnLeft) {
			p.left = c.right;
		} else {
			p.right = c.right;
		}
		return c;
	}
	
	/**
	 * display tree ordered by line levels
	 */
	public void display() {
		LinkQueue<Node<T>> q = new LinkQueue<>();
		Node<T> c = root;
		
		if (c == null) return;
		q.add(c);
		
		int qSize;
		while (true) {
			qSize = q.size();
			if (qSize == 0) break;
			
			while (--qSize >= 0) {
				c = q.poll();
				System.out.print(c.data.toString() + " ");
				
				if (c.left != null) {
					q.add(c.left);
				} 
				if (c.right != null) {
					q.add(c.right);
				}
			}
			System.out.println();
		}
	}
	
	private void updateHeight() {
		
	}
	
	/*
	 * get height of the tree
	 */
    private int height(Node<T> n) {
    	if (n == null) return 0;
    	return n.height;
    }
    
	/*
	public void display2() {
		inOrder(root);
	}
	
	private void inOrder(Node<T> root) {
		if(root != null) {
			inOrder(root.left);
			System.out.print(root.data.toString() + " ");
			inOrder(root.right);
		}
	}
	*/
}
