/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chapter.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dungptm2
 */
public class ClimbingStair {
    
    Map<Integer, Integer> cache = new HashMap<>();
    
    public int climbStairs2(int n) {
        if (n==1) {
            return 1;
        }
        
        if (n == 2) {
            return 2;
        }
        
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        
        int ret = climbStairs(n-1) + climbStairs(n-2);
        cache.put(n, ret);
        return ret;
    }
    
    public int climbStairs(int n) {
        int waysN1 = 1;
        int waysN2 = 1;
        int waysN = 1;
        for (int i = 1; i < n; i++) {
            waysN = waysN1 + waysN2;
            waysN1 = waysN2;
            waysN2 = waysN;
        }
        
        return waysN;
    }
    
    public static void main(String[] args) {
        int ret = new ClimbingStair().climbStairs(3);
        
        System.out.println("ret = " + ret);
        
        System.exit(0);
    }
}
