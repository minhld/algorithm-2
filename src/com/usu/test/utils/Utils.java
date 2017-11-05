package com.usu.test.utils;

public class Utils {
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
