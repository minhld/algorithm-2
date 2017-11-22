package com.usu.test.leetcode;

/**
 * Regular Expression Matching
 * 
 * @author minhld
 * 
 */
public class test10_regular_expression extends Thread {
	public void run() {
		String s = "ca";
		String p = "c.*a";
		System.out.println("result: " + isMatch(s, p));
	}
	
	public static void main(String args[]) {
		new test10_regular_expression().start();
	}
	
	public boolean isMatch(String s, String p) {
		return false;
	}
	
	public boolean isMatch2(String s, String p) {
		int j = s.length() - 1;
        for (int i = p.length() - 1; i >= 0; i--) {
            
            if (j >= 0 && p.charAt(i) == s.charAt(j)) {
                j--;
            } else if (j >= 0 && p.charAt(i) != s.charAt(j) && p.charAt(i) != '.' && p.charAt(i) != '*') {
                return false;
            } else if (p.charAt(i) == '.') {
                j--;
            } else if (p.charAt(i) == '*') {
                if (i == 0) return false;
                char l = p.charAt(i - 1);
                if (l == '.' && i == 1) {
                    return true;
                } else if (l == '.' && i > 1) {
                    l = p.charAt(i - 2);
                    while (j >=0 && s.charAt(j) != l) {
                        j--;
                    }
                    i = i - 1;
                } else if (l != '.') {
                    while(j >= 0 && s.charAt(j) == l) {
                        j--;
                    }
                    
                    i = i - 1;
                }
            } else if (j < 0 && p.charAt(i) != '*') {
                return false;
            }
        }
        
        if (j >= 0) return false;
        
        return true;
    }
}
