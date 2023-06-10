/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chapter.dp;

/**
 *
 * @author dungptm2
 */
public class UniquePaths {
    
    /**
     * 
     * for (int i = 1; i <= target; ++i) 
     * { for (int j = 0; j < ways.size(); ++j)
     *      { if (ways[j] <= i) { 
     *              dp[i] += dp[i - ways[j]]; 
     *      } 
     *  } 
     * }
     * 
     * 
     */
    
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        
        return dp[m-1][n-1];
    }
    
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        
        int ret = new UniquePaths().uniquePaths(m, n);
        
        System.out.println("ret = " + ret);
        
        System.exit(0);
    }
}
