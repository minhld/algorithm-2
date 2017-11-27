package com.usu.test.leetcode;

import java.util.ArrayList;
import java.util.List;

public class test22_generate_parentheses extends Thread {
	public void run() {
		generateParenthesis(3);
	}
	
	public static void main(String args[]) {
		new test22_generate_parentheses().start();
	}
	
	public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        
        String[] subList = addPar(n * 2 - 2, 0);
        for (String s : subList) {
            list.add("(" + s + ")");
        }
        return list;
    }

    private String[] addPar(int len, int lev) {
    	if (len == 1 && lev == 1) {
            return new String[] { ")" };
        } else if (len == 1 && lev == -1) {
            return new String[] { "(" };
        } else if (len == 1) {
            return new String[] { "A" };
        }
        
        List<String> list = new ArrayList<>();

        String[] s = addPar(len - 1, lev + 1);
        for (int j = 0; j < s.length; j++) {
            list.add("(" + s);
        }

        s = addPar(len - 1, lev - 1);
        for (int j = 0; j < s.length; j++) {
            list.add(")" + s);
        }
        return list.toArray(new String[] {});
    }
}
