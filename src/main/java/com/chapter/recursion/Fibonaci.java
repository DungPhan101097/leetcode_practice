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
public class Fibonaci {
    
    Map<Integer, Integer> cache = new HashMap<>();
    
    public int fib(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        
        if (n == 0) {
            return 0;
        } 
        
        if (n == 1) {
            return 1;
        }
        
        int ret = fib(n-1) + fib(n-2); 
        cache.put(n, ret);
        return ret;
    }
    
    public static void main(String[] args) {
        
        int ret = new Fibonaci().fib(4);
        
        System.out.println("ret = " + ret);        
        
        System.exit(0);
    }
}
