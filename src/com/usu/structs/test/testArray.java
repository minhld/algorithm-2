package com.usu.structs.test;

import com.usu.structs.Array;
import com.usu.test.utils.Utils;

public class testArray extends Thread {
	public void run() {
		Array a = new Array(100);
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
