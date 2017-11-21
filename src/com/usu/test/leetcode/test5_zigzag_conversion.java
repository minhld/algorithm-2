package com.usu.test.leetcode;

import com.usu.structs.HashMap;

public class test5_zigzag_conversion {
	/**
	 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
		P   A   H   N
		A P L S I I G
		Y   I   R
		And then read line by line: "PAHNAPLSIIGYIR"
		Write the code that will take a string and make this conversion given a number of rows

	 * @param s
	 * @param numRows
	 * @return
	 */
	public String convert(String s, int numRows) {
        int slen = s.length();
        int[] marks = new int[slen];
        boolean dir = true;
        int count = 0;
        
        // if s is empty
        if (s.equals("")) return "";
        
        // if there is only one layer
        if (numRows == 1) return s;
        
        for (int i = 0; i < slen; i++) {
            marks[i] = count;
            if (count == numRows - 1) {
                dir = false;
            } else if (count == 0) {
                dir = true;
            }
            count = dir ? count + 1 : count - 1;
        }
        
        // use the hash to store strings of each row
        HashMap<Integer, StringBuffer> hash = new HashMap<>();
        StringBuffer b;
        for (int i = 0; i < slen; i++) {
            // add a new string buffer to the hash if it is not available
            b = hash.get(marks[i]);
            if (b == null) {
                b = new StringBuffer();
            }
            
            // append to the string and save to the hash
            b.append(s.charAt(i));
            hash.put(marks[i], b);
        } 
        
        // iterate through the hash to get the entire string
        StringBuffer t = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            b = hash.get(i);
            if (b != null) {
                t.append(b.toString());
            }
        }
        return t.toString();
    }
}
