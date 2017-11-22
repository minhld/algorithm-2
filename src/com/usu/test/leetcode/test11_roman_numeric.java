package com.usu.test.leetcode;

/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 *        	I	V	X	L	C	D	M
 * Value	1	5	10	50	100	500	1,000
 * 
 * @author minhld
 *
 */
public class test11_roman_numeric extends Thread {
	public static void main(String args[]) {
		new test11_roman_numeric().start();
	}
	
	public void run() {
		int num = 3439;
		System.out.println(print(num));
	}
	
	public String intToRoman(int num) {
        return print(num);
    }
    
    String print(int num) {
        String numStr = Integer.toString(num);
        StringBuffer b = new StringBuffer();
        int val;
        int pow = numStr.length() - 1;
        for (int i = 0; i < numStr.length(); i++) {
            val = Integer.parseInt(numStr.substring(i, i + 1));
            b.append(print(val, pow));
            pow--;
        }
        return b.toString();
    }
    
    String print(int val, int pow) {
        StringBuffer b = new StringBuffer();
        if (val < 4) {
            for (int i = 0; i < val; i++) {
                if (pow == 0) {
                    b.append('I');
                } else if (pow == 1) {
                    b.append('X');
                } else if (pow == 2) {
                    b.append('C');
                } else if (pow == 3) {
                    b.append('M');
                }
            }
        } else if (val == 4) {
            if (pow == 0) {
                b.append("IV");
            } else if (pow == 1) {
                b.append("XL");
            } else if (pow == 2) {
                b.append("CD");
            } 
        } else if (val > 4 && val < 9) {
            if (pow == 0) {
                b.append("V");
            } else if (pow == 1) {
                b.append("L");
            } else if (pow == 2) {
                b.append("D");
            }
            for (int i = 0; i < val - 5; i++) {
                if (pow == 0) {
                    b.append('I');
                } else if (pow == 1) {
                    b.append('X');
                } else if (pow == 2) {
                    b.append('C');
                } 
            }
        } else if (val == 9) {
            if (pow == 0) {
                b.append("IX");
            } else if (pow == 1) {
                b.append("XC");
            } else if (pow == 2) {
                b.append("CM");
            }
        }
        
        return b.toString();
    }
}
