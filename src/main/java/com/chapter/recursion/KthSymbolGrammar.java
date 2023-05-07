/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chapter.recursion;

/**
 *
 * @author dungptm2
 */
public class KthSymbolGrammar {
    /**
     * 5
     * 0
     * 01
     * 0110
     * 01101001
     * 0110100110010110
     * 
     * 
     */
    //Try to represent the current (N, K) in terms of some (N-1, prevK). What is prevK ?
    // dòng sau dài gấp đôi dòng trước, nữa đầu giữ nguyên, nữa sau đổi ngược bit -> chứng minh ?
    // độ dài bit mỗi row: 1, 2, 4, 8, 16 (2^n)
    //
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        
        int lenBitAtRowNth = (int) Math.pow(2, n-1);
        if (k > lenBitAtRowNth /2) {
            int bitPrevRow = kthGrammar(n-1, k - lenBitAtRowNth/2);
            return 1 - bitPrevRow;
        } else {
            return kthGrammar(n - 1, k);
        }
    }
    
    public static void main(String[] args) {
        int ret = new KthSymbolGrammar().kthGrammar(2, 2);
        
        System.out.println("ret = " + ret);
        
        System.exit(0);
    }
    
}
