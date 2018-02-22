package com.usu.test.leetcode;

public class test70_climstairs {
    public int climbStairs(int n) {
        int num2 = n / 2;
        int num1;
        long total = 0;
        for (int i = 0; i <= num2; i++) {
            num1 = n - 2 * i;
            total += combination(num1 + i, i); 
            System.out.println(total + "," + (num1 + i) + "," + i + "," + combination(num1 + i, i));
        }
        return (int) total;
    }
    
    private long combination(int n, int i) {
        if (i == 0) return 1;
        
        double res = 1;

        for (int j = n; j > (n - i); j--) {
            res = res * j;
            res = res / (n - j + 1);
        }
        
        return (long) res;
    }

}
