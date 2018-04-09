package com.usu.test.interviews;

public class test_06_minortest extends Thread {
	public void run() {
		int sub = 'c' - 'a';
		
		System.out.println(sub);
	}
	
	public static void main(String args[]) {
		new test_06_minortest().start();
	}
}
