package com.usu.test.leetcode;

import com.usu.structs.HashMap;

/**
 *         	I	V	X	L	C	D	M
 * Value	1	5	10	50	100	500	1,000
 * 
 * @author minhld
 *
 */
public class test12_roman_to_integer extends Thread {
	HashMap<String, Integer> hash = new HashMap<>();
    
    public int romanToInt(String s) {
        hash.put("I", 1);
        hash.put("V", 5);
        hash.put("IV", 4);
        hash.put("X", 10);
        hash.put("IX", 9);
        hash.put("L", 50);
        hash.put("XL", 40);
        hash.put("C", 100);
        hash.put("XC", 90);
        hash.put("D", 500);
        hash.put("CD", 400);
        hash.put("M", 1000);
        hash.put("CM", 900);
            
        int sum = 0, val = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && compare(s.substring(i, i + 1), s.substring(i + 1, i + 2))) {
                val = hash.get(s.substring(i, i + 2));
                sum += val;
                i++;
            } else {
                val = hash.get(s.substring(i, i + 1));
                sum += val;
            }
        }
        
        return sum;
    }
    
    boolean compare(String c1, String c2) {
        int v1 = hash.get(c1);
        int v2 = hash.get(c2);
        return v1 < v2;
    }
}
