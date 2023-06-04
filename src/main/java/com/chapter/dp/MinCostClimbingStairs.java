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
public class MinCostClimbingStairs {
    
    //[10,15,20]
    public int minCostClimbingStairs(int[] cost) {
        int top = cost.length;
        int[] dp = new int[top+1];
        
        for (int i = 2; i <= top; i++) {
            dp[i] = Math.min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1]);
        }
        
        return dp[top];
    }
    
    
    public static void main(String[] args) {
        int[] cost = new int[] {1,100,1,1,1,100,1,1,100,1};
        int ret = new MinCostClimbingStairs().minCostClimbingStairs(cost);
        
        System.out.println("ret = " + ret);
        
        System.exit(0);
    }
}
