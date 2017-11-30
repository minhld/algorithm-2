package com.usu.test.leetcode;

/**
 * 263. check if a number is ugly (multiples of 2, 3 and 5)
 * 
 * @author minhld
 *
 */
public class test263_ugly_number {
	public boolean isUgly(int num) {
        if (num == 0) return false;
        
        while (num % 2 == 0) {
            num = num / 2;
        }
        
        while (num % 3 == 0) {
            num = num / 3;
        }
        
        while (num % 5 == 0) {
            num = num / 5;
        }
        
        return num == 1;
    }
}
