/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chapter.dp;

import java.util.Arrays;

/**
 *
 * @author dungptm2
 */
public class CoinChange {
    //coins = [1,2,5], amount = 11
    // 3
    //11 = 5 + 5 + 1
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        
        // array lưu số đồng ít nhất để có thể tạo đc amount
        //index: amount tại lúc đó
        // mỗi index: số đồng ít nhất để có thể tạo được amount tại thời điểm đó (index= amount)
        // mỗi index: so sánh lần lượt từng khả năng chính nó với index tại vị trí phía trước (nghĩa là đồng hiện tại được chọn)
        int[] dp = new int[amount+1];
        dp[0] = 0;
                
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }               
            }
        }
        
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
    
    public static void main(String[] args) {
        
        int[] coins = new int[] {2};
        int amount = 3;
        
        int ret = new CoinChange().coinChange(coins, amount);               
        
        System.out.println("ret = " + ret);
        
        System.exit(0);
    }
    
}
