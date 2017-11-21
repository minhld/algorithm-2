package com.usu.test.dp;

import java.util.Stack;

import com.usu.structs.LinkStack;

public class test5_longestPalin extends Thread {
	public void run() {
		String s = "forgeeksskeegfofgeeasdjhasdnbsbndhsrs";
		// String s = "sdnbsbndhsr";
		longestPalindrome(s);
	}
	
	public void longestPalindrome(String s) {
		char c;
		int z = 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			
			// find the palindrome with two cores
			z = i - 1;
			while (z >= 0 && s.charAt(z) == s.charAt(i)) {
				z--;
				i++;
				count++;
			}
			if (z >= 0 && z < i - 1) {
				System.out.println("" + s.substring(z + 1, z + 1 + count * 2));
				count = 0;
			}
			
			// find the palindrome with one core
			z = i - 2;
			while (z >= 0 && i < s.length() && s.charAt(z) == s.charAt(i)) {
				z--;
				i++;
				count++;
			}
			if (z >= 0 && z < i - 2) {
				System.out.println("" + s.substring(z + 1, z + 2 + count * 2));
				count = 0;
			}
		}
	}
	
	public static void main(String args[]) {
		new test5_longestPalin().start();
	}
}
