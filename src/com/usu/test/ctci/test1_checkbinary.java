package com.usu.test.ctci;

import java.util.ArrayList;
import java.util.List;

import com.usu.structs.tree.Node;

public class test1_checkbinary extends Thread {
	public void run() {
//		Node<Integer> root = new Node<Integer>(10, 10);
//		Node<Integer> n1 = new Node<>(5, 5);
//		Node<Integer> n2 = new Node<>(8, 8);
//		Node<Integer> n3 = new Node<>(12, 12);
//		Node<Integer> n4 = new Node<>(15, 15);
//		Node<Integer> n5 = new Node<>(3, 3);
//		Node<Integer> n6 = new Node<>(7, 7);
//		Node<Integer> n7 = new Node<>(6, 6);
//		root.left = n1;
//		root.right = n2;
//		n1.left = n3;
//		n1.right = n4;
//		n2.left = n5;
//		n3.right = n6;
//		n4.left = n7;

		Node<Integer> root = new Node<Integer>(2, 2);
		Node<Integer> n1 = new Node<>(1, 1);
		Node<Integer> n2 = new Node<>(3, 3);
		root.left = n1;
		root.right = n2;
		
		boolean isValid = isValidBST(root);
		System.out.println("result: " + isValid);
	}
	
	public boolean isValidBST(Node<Integer> root) {
        List<Integer> list = travelBST(root);
        for (int i : list) {
			System.out.print(i + " ");
		}
        System.out.println();
        
        if (list.size() == 1) return true;
        
        boolean isBst = true;
        int p = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && p >= list.get(i)) {
                return false;
            } else if (i >= 0) {
                p = list.get(i);
            }
        }
        return isBst;
    }
	
	public List<Integer> travelBST(Node<Integer> tree) {
		List<Integer> list = new ArrayList<>();
		if (tree == null) return list;
		
		List<Integer> leftList = travelBST(tree.left);
		for (int i : leftList) {
			list.add(i);
		}
		list.add(tree.data);
		List<Integer> rightList = travelBST(tree.right);
		for (int i : rightList) {
			list.add(i);
		}
		
		return list;
	}
	
	public static void main(String args[]) {
		new test1_checkbinary().start();
	}
}
