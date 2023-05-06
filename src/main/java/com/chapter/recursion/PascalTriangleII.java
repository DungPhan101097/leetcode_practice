/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chapter.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author dungptm2
 */
public class PascalTriangleII {
    
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = doGetRow(rowIndex);
        
        return ret;
    }
    
    public List<Integer> getRow2(int rowIndex) {
        
        List<Integer> preRow = new ArrayList<>(1);
        preRow.add(1);
        
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>(rowIndex + 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(preRow.get(j-1) + preRow.get(j));
                }
            }
            
            if (i == rowIndex) {
                return row;
            }
            
            preRow = row;
        }
        
        return preRow;
    }
    
    public List<Integer> doGetRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>(rowIndex + 1);
        
        if (rowIndex == 0) {
            ret.add(1);
            return ret;
        }
        
        if (rowIndex == 1) {
            ret.add(1);
            ret.add(1);
            return ret;
        }
        
        List<Integer> preRow = doGetRow(--rowIndex);
        ret.add(1);
        for (int i = 0; i < preRow.size() - 1; i++) {
            ret.add(preRow.get(i) + preRow.get(i+1));
        }
        ret.add(1);
        return ret;
    }
    
    public static void main(String[] args) {
        
        List<Integer> ret = new PascalTriangleII().getRow2(3);
        
        System.out.println("ret = " + ret); 
        
        System.exit(0);
    }
}
