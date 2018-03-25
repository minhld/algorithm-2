package com.usu.test.leetcode;

public class test714_buysell_stock2 {
	// DP - solution 2 - from the discussion
    public int maxProfit(int[] a, int fee) {
        // if the array is null or just one element - return 0
        if (a.length <= 1) return 0;
        
        int len = a.length;
        
        int[] buy = new int[len];
        int[] sell = new int[len];
        
        buy[0] = -a[0];
        
        for (int i = 1; i < len; i++) {
            // not buy || buy with the money from the last sell (sell[i - 1] - a[i])
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - a[i]);
            // sell from the last buy (buy[i - 1] + a[i] - fee) || not sell
            sell[i] = Math.max(buy[i - 1] + a[i] - fee, sell[i - 1]);
        }
        
        return sell[len - 1]; 
        // return Math.max(buy[len - 1], sell[len - 1]);
    }
    
    // DP - solution 1
    public int maxProfit2(int[] a, int fee) {
        if (a.length <= 1) return 0;
        
        int len = a.length;
        
        int[] dp = new int[len];
        dp[0] = 0;
        dp[1] = a[1] - a[0] - fee > 0 ? a[1] - a[0] - fee : 0;
        
        int each = 0, maxEach = 0;
        
        for (int i = 2; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // move back until it meets a bigger number
                if (a[i] <= a[j]) break;
                
                each = a[i] - a[j] - fee > 0 ? (a[i] - a[j] - fee) + dp[j] : dp[j];
                maxEach = Math.max(maxEach, each);
            }
            dp[i] = Math.max(maxEach, dp[i - 1]);
        }
        
        return dp[len - 1];
    }
}
