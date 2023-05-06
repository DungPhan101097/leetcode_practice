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
public class CombinationIterator {
    
    private int from;
    private int start;
    private char[] charArrays;
    private int combinationLen;
    
    public CombinationIterator(String characters, int combinationLength) {
        this.charArrays = characters.toCharArray();
        this.combinationLen = combinationLength;
        this.from = 0;
        
    }
}
