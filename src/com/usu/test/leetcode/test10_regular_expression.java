package com.usu.test.leetcode;

/**
 * Regular Expression Matching
 * 
 * @author minhld
 * 
 */
public class test10_regular_expression extends Thread {
	public void run() {
		String s = "ab";
		String p = ".*";
		System.out.println("result: " + isMatch(s, p));
	}
	
	public static void main(String args[]) {
		new test10_regular_expression().start();
	}
	
	public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }
    
    /**
     * is - current index of s, ip - current index of p
     */ 
    public boolean isMatch(String s, String p, int is, int ip) {
    	if (ip == p.length() && is < s.length()) {
            return false;
        } else if (is == s.length() - 1 && ip == p.length() - 1) {
            return p.charAt(ip) == '.' ? true : s.charAt(is) == p.charAt(ip);
        } else if (is < s.length() && ip < p.length() - 1 && s.charAt(is) == p.charAt(ip) && p.charAt(ip + 1) != '*') {
            return isMatch(s, p, is + 1, ip + 1);
        } else if (is < s.length() && ip < p.length() - 1 && s.charAt(is) != p.charAt(ip) && p.charAt(ip + 1) != '*') {
            return p.charAt(ip) == '.' ? isMatch(s, p, is + 1, ip + 1) : false;
        } else if (is < s.length() && ip < p.length() - 1 && s.charAt(is) != p.charAt(ip) && p.charAt(ip + 1) == '*') {
            return p.charAt(ip) == '.' ? isMatch(s, p, is + 1, ip) || isMatch(s, p, is, ip + 2) : isMatch(s, p, is, ip + 2);
        } else if (is < s.length() && ip < p.length() - 1 && s.charAt(is) == p.charAt(ip) && p.charAt(ip + 1) == '*') {
            return isMatch(s, p, is, ip + 2) || isMatch(s, p, is + 1, ip);
        } else if (s.length() == 0 || is == s.length()) {
            if (ip < p.length() - 1 && p.charAt(ip + 1) == '*') {
                return isMatch(s, p, is, ip + 2);
            } else if (ip == p.length()) return true;
        }
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
