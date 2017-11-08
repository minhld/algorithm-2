package com.usu.structs.test;

import com.usu.structs.Array;
import com.usu.structs.OrderedArray;
import com.usu.test.utils.Utils;

public class testArray extends Thread {
	public void run() {
//		testNormalArray();
		testOrderedArray();
	}
	
	public void testOrderedArray() {
		OrderedArray a = new OrderedArray(15);
		for (int i = 0; i < 16; i++) {
			int rand = (int)(Math.random() * 100);
			a.insert(rand);
		}
		a.print();
		
		int val = Utils.openInput();
		System.out.println("attempting to delete " + a.delete(val));
		a.print();
	}
	
	public void testNormalArray() {
		Array a = new Array(14);
		for (int i = 0; i < 15; i++) {
			int rand = (int)(Math.random() * 100);
			a.insert(rand);
		}
		a.print();
		
		int val = Utils.openInput();
		System.out.println("attempting to delete " + a.delete(val));
		a.print();
	}
	
	public static void main(String args[]) {
		new testArray().start();
	}
}
