package com.usu.test.leetcode;

public class test746_min_cost_stairs {
	/**
     * DP: with help/idea from the discussion
     */
    public int minCostClimbingStairs(int[] cost) {
        // since length of cost will be >= 2
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        
        // i > 2
        int len = cost.length;
        int[] dp = new int[len + 1];
        
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i <= len; i++) {
            int val = (i == len ? 0 : cost[i]);
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + val;
        }
        
        return Math.min(dp[len - 1], dp[len - 2]);
    }

    /* - RECURSION - Did not pass (time exceeded)
    public int minCostClimbingStairs(int[] cost) {
        // just to index 1
        int minCostOne = minCostClimbingStairs(cost, 1, 0);
        // start with index 0
        int minCostZero = minCostClimbingStairs(cost, 0, 0);
        
        return minCostOne > minCostZero ? minCostZero : minCostOne;
    }
    
    public int minCostClimbingStairs(int[] cost, int idx, int currCost) {
        if (idx == cost.length) {
            return currCost;
        } else if (idx == cost.length - 1) {
            currCost += cost[idx];  // jump 1 step
            return currCost;
        }
        
        int jump1 = minCostClimbingStairs(cost, idx + 1, currCost + cost[idx]);
        int jump2 = minCostClimbingStairs(cost, idx + 2, currCost + cost[idx]);
    
        return jump1 < jump2 ? jump1 : jump2;
    }
    */
}
