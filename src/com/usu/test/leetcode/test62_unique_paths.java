package com.usu.test.leetcode;

public class test62_unique_paths {
	
	// use dynamic programming
	public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j > 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (i > 0 && j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (i > 0 && j > 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; 
                }
            }
        }

        return dp[m - 1][n - 1];
    }
    
//     // use recursion
//     public int uniquePaths(int m, int n, int i, int j) {
//         if (i == m - 1 && j == n - 1) return 1;     
//         if (i == m - 1) return uniquePaths(m, n, i, j + 1);
//         if (j == n - 1) return uniquePaths(m, n, i + 1, j);
//         return uniquePaths(m, n, i + 1, j) + uniquePaths(m, n, i, j + 1);
//     }
}
