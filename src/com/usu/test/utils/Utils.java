package com.usu.test.utils;

import java.util.Scanner;

public class Utils {
	/**
	 * create an array with random values
	 * 
	 * @param size
	 * @param range
	 * @return
	 */
	public static long[] createArray(int size, int range) {
		long[] a = new long[size]; 
		for (int i = 0; i < a.length; i++) {
			long rand = (long)(Math.random() * range);
			a[i] = rand;
		}
		return a;
	}
	
	public static int openInput() {
		Scanner reader = null;
		try {
			reader = new Scanner(System.in);
			System.out.print("Enter a value: ");
			return reader.nextInt();
		} catch (Exception e) { 
			// not sure 
		} finally {
			reader.close(); 
		}
		return -1;
	}
	
	public static int[] getCharNums(String s) {
		int[] sChars = new int[128];
		for (int i = 0; i < s.length(); i++) {
			sChars[s.charAt(i)]++;
		}
		return sChars;
	}
	
	public static int findDiff(String s1, String s2) {
		int[] s1Chars = Utils.getCharNums(s1);
		int[] s2Chars = Utils.getCharNums(s2);

		int diffCount = 0;
		for (int i = 0; i < s1Chars.length; i++) {
			if (Math.abs(s1Chars[i] - s2Chars[i]) > 0) {	// difference point
				diffCount++;
			}
		}
		return diffCount;
	}
}
