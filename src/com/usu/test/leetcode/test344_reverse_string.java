package com.usu.test.leetcode;

public class test344_reverse_string {
	public String reverseString(String s) {
        char[] news = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            news[s.length() - i - 1] = s.charAt(i);
        }
        return new String(news);
    }
}
