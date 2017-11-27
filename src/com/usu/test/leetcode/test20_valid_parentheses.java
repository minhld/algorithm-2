package com.usu.test.leetcode;

import com.usu.structs.Stack;

public class test20_valid_parentheses {
	
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!stack.isEmpty() && isMatched(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    
    private boolean isMatched(char s, char c) {
        return s == '(' && c == ')' || s == '{' && c == '}' || s == '[' && c == ']';
    }
}
