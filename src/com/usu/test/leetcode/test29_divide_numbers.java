package com.usu.test.leetcode;

public class test29_divide_numbers {
	/**
	 * without recursion
	 * 
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public int divide(int dividend, int divisor) {
        long sum = 0;
        long co = 0;
        int sign = 1;
        
        // convert to the wider range
        long top = (long) dividend;
        long bottom = (long) divisor;

        
        if (bottom == 0) {
            throw new java.lang.ArithmeticException("/ by zero");
        }
     
        // get the sign of the output
        if (top < 0 && bottom > 0 || top > 0 && bottom < 0) {
            sign = -1;
        } 

        // reverse sign if the value is below zero
        top = top > 0 ? top : -top;
        bottom = bottom > 0 ? bottom : -bottom;
        
        //
        long totalCo = 0;
        long totalSum = 0;
        long orgTop = top;
        while (sum + sum <= top) {
            sum += sum == 0 ? bottom : sum;
            co += co == 0 ? 1 : co;
            
            if (sum + sum >= top && top >= sum) {
                top = top - sum;
                totalSum += sum;
                sum = 0; 
                totalCo += co;
                co = 0;
            }
        }
        
        // iterate through the rest part
        while (totalSum + bottom <= orgTop) {
            totalSum += bottom;
            totalCo++;
        }
        
        // assign sign if needed
        totalCo = sign > 0 ? totalCo : -totalCo;
        
        // overflow case
        if (totalCo > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        
        return (int) totalCo;
    }
}
