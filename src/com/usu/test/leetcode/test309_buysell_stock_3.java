package com.usu.test.leetcode;

public class test309_buysell_stock_3 {
	public int maxProfit(int[] a) {
        int len = a.length;
        
        // if there is less than one item -> 
        // no buying/selling -> return 0
        if (len <= 1) return 0;
        
        int[] buy = new int[len];
        int[] sell = new int[len];
        
        // for the first item, buying mean losing money: -a[0]
        buy[0] = -a[0];
        sell[0] = 0;
        buy[1] = Math.max(-a[0], -a[1]);
        sell[1] = Math.max(-a[0] + a[1], 0);
        
        for (int i = 2; i < len; i++) {
            // don't buy, or buy if sell 2 days ago
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - a[i]); 
            // sell or don't sell (sell[i - 1])
            sell[i] = Math.max(buy[i - 1] + a[i], sell[i - 1]);
        }
        
        return sell[len - 1]; 
    }
}
