/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chapter.recursion;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author dungptm2
 */
public class NQueensII {
    
    Set<Integer> cols = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>(); // r+c
    Set<Integer> negDiag = new HashSet<>(); //r-c
    
    public int totalNQueens(int n) {
        int result = backtrackQueue(0, 0, n);
        return result;
    }
    
    private int backtrackQueue(int row, int count, int n) {
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || posDiag.contains(row + col)
                    || negDiag.contains(row - col)) {
                continue;
            }
            
            if (row == n -1) {
                count++;
            } else {
                cols.add(col);
                posDiag.add(row + col);
                negDiag.add(row - col);
                count = backtrackQueue(row + 1, count, n);
                cols.remove(col);
                posDiag.remove(row + col);
                negDiag.remove(row - col);
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        
        int ret = new NQueensII().totalNQueens(4);
        
        System.out.println("ret = " + ret);
        
        System.exit(0);
    }
}
