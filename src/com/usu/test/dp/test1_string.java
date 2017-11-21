package com.usu.test.dp;

/**
 * find the longest common string from the two strings  
 * 
 * @author minhld
 *
 */
public class test1_string extends Thread {
	public void run() {
		String s1 = "quetzalcoatl";
		String s2 = "tezcatlipoca";
		int maxCommon = findLongestCommonString(s1, s2);
		System.out.println("max length: " + maxCommon);
	}
	
	public int findLongestCommonString(String s1, String s2) {
		int[][] maxs = new int[s1.length()][s2.length()];
		
		char c1, c2;
		int max = 0;
		for (int i = 0; i < s1.length(); i++) {
			c1 = s1.charAt(i);
			for (int j = 0; j < s2.length(); j++) {
				c2 = s2.charAt(j);
				if (i == 0 || j == 0) {
					maxs[i][j] = 0;
				} else if (c1 == c2) {
					maxs[i][j] = maxs[i - 1][j - 1] + 1;
					max = Math.max(max, maxs[i][j]);
				}
				System.out.print(maxs[i][j] + " ");
			}
			System.out.println();
		}
		return max;
	}
	
	public static void main(String args[]) {
		new test1_string().start();
	}
}
