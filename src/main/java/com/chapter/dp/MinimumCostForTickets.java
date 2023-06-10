/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chapter.dp;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author dungptm2
 */
public class MinimumCostForTickets {
    
    //days = [1,4,6,7,8,20], costs = [2,7,15]
    //days = [1,2,3,4,5,6], costs = [2,7,15]
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        
        for (int i = 1; i < 366; i++) {
            if (Arrays.binarySearch(days, i) < 0) {
                dp[i] = dp[i-1];
                continue;
            }
            
            
            int cost1day = i-1 >= 0 ? dp[i-1] + costs[0] : costs[0];
            int cost7day = i-7 >= 0 ? dp[i-7] + costs[1] : costs[1];
            int cost30day = i-30 >= 0 ? dp[i-30] + costs[2]: costs[2];
            
            dp[i] = Math.min(Math.min(cost1day, cost7day), cost30day);
        }
        
        return dp[365];
    }
    
    public static void main(String[] args) {
        
        int[] days = new int[] {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = new int[] {2,7,15};
        
        int ret = new MinimumCostForTickets().mincostTickets(days, costs);
        
        System.out.println("ret = " + ret);        
        
        System.exit(0);
    }
}
