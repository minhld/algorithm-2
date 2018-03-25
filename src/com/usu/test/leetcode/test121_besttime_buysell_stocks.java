package com.usu.test.leetcode;

public class test121_besttime_buysell_stocks {
	public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        
        int[] dp = new int[len + 1];
        dp[0] = prices[0];
            
        int max = 0;
        
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(prices[i], dp[i - 1]);
            max = Math.max(max, prices[i] - dp[i - 1]);
        }
        
        return max;
    }
}
