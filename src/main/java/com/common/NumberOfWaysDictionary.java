/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common;

/**
 *
 * @author dungptm2
 */
public class NumberOfWaysDictionary {
    
    /**words = ["acca","bbbb","caca"], target = "aba"
     * 
     * a b a
     * 
     * a c c a
     * b b b b
     * c a c a
     */
    public int numWays(String[] words, String target) {
        int alphabet = 26;
        int mod = 1000000007;
        int m = target.length();
        int k = words[0].length();
        
        //cnt[a][0] = 1      
        int cnt[][] = new int[alphabet][k];
        
        for (int j = 0; j < k; j++) {
            for (String word : words) {
                cnt[word.charAt(j) - 'a'][j] ++;
            }
        }
        /**
         * 1 1 2 2
         * 1 1 1 1
         * 1 1 0 0
         */
        
        // db[i][j]: number of ways to build prefix of "target" in len = i with j collums lelf first 
        long dp[][] = new long[m+1][k+1];
        dp[0][0] = 1;
        for (int i = 0 ; i <= m ; i++) {
            for (int j = 0; j < k; j++) {
                if (i < m) {
                    dp[i+1][j+1] += cnt[target.charAt(i) - 'a'][j] * dp[i][j];
                    dp[i + 1][j + 1] %= mod;
                }
                dp[i][j + 1] += dp[i][j];
                dp[i][j + 1] %= mod;                
            }
            int a = 1;
        }
        
        /**
         * 1 1 1 1 1
         * 0 1 2 2 4
         * 0 0 1 3 5
         * 0 0 0 0 6
         */
        
        return (int) dp[m][k];
    }
    
    public static void main(String[] args) {
        String[] words = new String[] {"acca","bbbb","caca"};
        String target = "aba";
        
        
        int ret = new NumberOfWaysDictionary().numWays(words, target);
        
        System.out.println("ret = " + ret);
                
        System.exit(0);
    }
    
}
