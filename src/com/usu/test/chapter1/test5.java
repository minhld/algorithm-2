package com.usu.test.chapter1;

import com.usu.test.utils.Utils;

public class test5 extends Thread {
	public void run() {
		String s1 = "palez";
		String s2 = "pales";
		boolean isID = isInsertDelete(s1, s2);
		boolean isR = isReplace(s1, s2);
		
		if (isID) {
			System.out.println("2 strings are insert/delete");
		}
		
		if (isR) {
			System.out.println("2 strings are replace");
		}
		
		if (!isID && !isR) {
			System.out.println("2 strings are not matched");
		}
	}
	
	public boolean isInsertDelete(String s1, String s2) {
		// if it is not an insert or delete
		if (Math.abs(s1.length() - s2.length()) != 1) {
			return false;
		}
		
		if (Utils.findDiff(s1, s2) > 1) return false;
		return true;
	}
	
	public boolean isReplace(String s1, String s2) {
		if (Math.abs(s1.length() - s2.length()) != 0) {
			return false;
		}
		
		int diffPoints = Utils.findDiff(s1, s2);
		if (diffPoints != 0 && diffPoints != 2) return false;
		return true;
	}
	
	public static void main(String args[]) {
		new test5().start();
	}
}
