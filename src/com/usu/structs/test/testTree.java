package com.usu.structs.test;

import com.usu.structs.tree.Tree;

public class testTree extends Thread {
	public void run() {
		Tree<Integer> t = new Tree<>();
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
		t.insert(30, 30);
		t.insert(22, 22);
		t.insert(32, 32);
		t.insert(32, 32);
		
		t.display();
		
		t.delete(15);
		t.delete(11);
		t.delete(20);
		
		t.display();
	}
	
	public static void main(String args[]) {
		new testTree().start();
	}
}
