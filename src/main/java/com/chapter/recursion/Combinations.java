/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chapter.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author dungptm2
 */
public class Combinations {
    
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> current = new ArrayList<>(k);
        
        doCombine(n, k, 1, current);
        
        return result;
    }
    
    private void doCombine(int n, int k, int curIndex, List<Integer> current) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = curIndex; i <= n; i++) {
            current.add(i);
            doCombine(n, k, ++curIndex, current);
            current.remove(Integer.valueOf(i));
        }
    }
    
    public static void main(String[] args) {
        int n = 4; 
        int k = 2;
        
        List<List<Integer>> ret = new Combinations().combine(n, k);
        
        System.out.println("ret = " + ret);
        
        System.exit(0);
    }
}
