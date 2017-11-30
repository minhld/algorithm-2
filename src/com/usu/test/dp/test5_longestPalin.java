package com.usu.test.dp;

public class test5_longestPalin extends Thread {
	public void run() {
		// String s = "forgeeksskeegfofgeeasdjhasdnbsbndhsrs";
		// String s = "sdnbsbndhsr";
		String s = "babad";
		longestPalindrome(s);
		longestPalindrome2(s);
	}
	
	/**
	 * find the largest palindrome by using 2-dimension matrix
	 * build by the string and the reversed string
	 * 	- if the two chars matched, maxs[i][j] = maxs[i][j] + 1; 
	 * 
	 * @param s
	 */
	public void longestPalindrome2(String s) {
		int len = s.length();
		int[][] maxs = new int[len][len];
		
		StringBuffer rev = new StringBuffer(len); 
		for (int i = len - 1; i >= 0; i--) {
			rev.append(s.charAt(i));
		}
		String rs = rev.toString();
		
		System.out.print("  ");
		for (int i = 0; i < len; i++) {
			System.out.print(s.charAt(i) + " ");
		}
		System.out.println();
		
		char c, rc;
		for (int i = 0; i < len; i++) {
			rc = rs.charAt(i);
			System.out.print(rc + " ");
			
			for (int j = 0; j < len; j++) {
				c = s.charAt(j);
				
				if (c == rc) {
					maxs[i][j] = (i == 0 || j == 0) ? 1 : maxs[i - 1][j - 1] + 1;
				} else {
					maxs[i][j] = 0;
				}
				System.out.print(maxs[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * run the array from 0 - s.length
	 * - check if the current item equals to the last item or 
	 * the item with index = index - 2
	 * 		- if not, go forward
	 * 		- if it does, run a while loop to to both directions 
	 * 	  	to check how further the palindrome string can be
	 * 
	 * @param s
	 */
	public void longestPalindrome(String s) {
		int z = 0;
		int count = 0;
		int max = 0;
		String p = "", maxP = "";
		
		for (int i = 0; i < s.length(); i++) {
	
			// find the palindrome with two cores
			z = i - 1;
			while (z >= 0 && s.charAt(z) == s.charAt(i)) {
				z--;
				i++;
				count++;
			}
			if (z >= 0 && z < i - 1) {
				p = s.substring(z + 1, z + 1 + count * 2);
				if (max < p.length()) {
					max = p.length();
					maxP = p;
				}
				System.out.println("res: " + p);
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
				p = s.substring(z + 1, z + 2 + count * 2);
				if (max < p.length()) {
					max = p.length();
					maxP = p;
				}
				System.out.println("res: " + p);
				count = 0;
			}
		}
	}
	
	public static void main(String args[]) {
		new test5_longestPalin().start();
	}
}
