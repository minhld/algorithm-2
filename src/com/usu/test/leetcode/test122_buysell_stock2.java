package com.usu.test.leetcode;

public class test122_buysell_stock2 {
	
	public int maxProfit(int[] a) {
        if (a.length <= 1) return 0;
        
        int len = a.length;
        
        int[] dp = new int[len];
        dp[0] = 0;
        dp[1] = a[1] - a[0] > 0 ? a[1] - a[0] : 0;
        
        int each = 0, maxEach = 0;
        
        for (int i = 2; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // avoid trace back from j if dp[j] == 0
                // (if dp[j] == 0 => dp[k] == 0 V k = 0->j, 
                // therefore we will skip moving backward from j where dp[j] == 0)
                if (dp[j] == 0 && a[i] <= a[j]) break;
                
                each = a[i] - a[j] > 0 ? a[i] - a[j] + dp[j] : dp[j];
                maxEach = Math.max(maxEach, each);
            }
            dp[i] = Math.max(maxEach, dp[i - 1]);
        }
        
        return dp[len - 1];
    }
}
