package com.usu.test.leetcode;

/**
 * Write a function to find the longest common prefix string 
 * amongst an array of strings. 
 * 
 * @author lee
 *
 */
public class test14_longest_common {
	public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        // if (strs.length == 1) return strs[0];
        
        StringBuffer b = new StringBuffer();
        char c;
        boolean allMatched = true;
        for (int i = 0; i < strs[0].length(); i++) {
            allMatched = true;
            c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != c) {
                    allMatched = false;
                    break;
                }
            }
            if (allMatched) {
                b.append(c);
            } else {
                break;
            }
        }
        return b.toString();
    }
}
