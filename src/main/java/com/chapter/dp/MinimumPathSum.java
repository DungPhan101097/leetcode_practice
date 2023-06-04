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
public class MinimumPathSum {
    
    public int minPathSum(int[][] grid) {
        int m = grid.length; //row
        int n = grid[0].length; //col
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }                
            }
        }
        
        return dp[m-1][n-1];
    }
    
    public static void main(String[] args) {
        
        int[][] a = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        
        int ret = new MinimumPathSum().minPathSum(a);
        
        System.out.println("ret = " + ret);
        
        System.exit(0);
    }
    
}
