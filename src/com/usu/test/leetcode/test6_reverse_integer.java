package com.usu.test.leetcode;

import com.usu.structs.Stack;

public class test6_reverse_integer {
	/**
	 * Given a 32-bit signed integer, reverse digits of an integer
	 * 
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
        // check if the integer is in the range of java integer
        String sx;
        try {
            sx = Integer.toString(x);
        } catch (Exception e) {
            // return 0 if it is overflow
            return 0;
        }
        
        Stack<Character> stack = new Stack<>();
        if (x < 0) sx = sx.substring(1);
        
        for (int i = 0; i < sx.length(); i++) {
            stack.push(sx.charAt(i));
        }
        
        StringBuffer xs = new StringBuffer();
        while (!stack.isEmpty()) {
            xs.append(stack.pop());
        }
        
        int absRet = 0;
        try {    
            absRet = Integer.parseInt(xs.toString()) * (x < 0 ? -1 : 1);
        } catch (Exception e) { }
        
        return absRet;
    }
}
