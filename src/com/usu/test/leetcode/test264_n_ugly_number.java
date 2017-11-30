package com.usu.test.leetcode;

/**
 * Write a program to find the n-th ugly number.
 * 
 * @author minhld
 *
 */
public class test264_n_ugly_number {
	public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        
        int count = 1;
        int num = 2;
        while (count < n) {
            if ((num % 2 == 0 || num % 3 == 0 || num % 5 == 0) && isUgly(num)) {
                count++;
            }
            num++;
        }
        
        return num - 1;
    }
    
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
