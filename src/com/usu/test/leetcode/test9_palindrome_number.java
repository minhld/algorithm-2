package com.usu.test.leetcode;

import com.usu.structs.Stack;

public class test9_palindrome_number {
	public boolean isPalindrome(int x) {
        String s;
        // get the string of the integer
        try {
            s = Integer.toString(x);
        } catch(Exception e) {
            return false;
        }
        
        if (x < 0) return false; // s = s.substring(1);
        
        int mid = 0, next = 0;
        int slen = s.length();
        
        // number with 1 digit is palindrome
        if (slen == 1) return true;
        
        // 
        if (slen == 2) {
            return s.charAt(0) == s.charAt(1);
        }
        
        // get the medium element
        if (slen % 2 == 1) {
            mid = (slen - 1) / 2 - 1;
            next = mid + 2;
        } else {
            mid = (int) Math.floor((slen - 1) / 2);
            next = mid + 1;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <= mid; i++) {
            stack.push(s.charAt(i));
        }
 
        while (next < slen && s.charAt(next++) == stack.peek()) {
            stack.pop();
        }
        
        return stack.isEmpty();
    }
}
