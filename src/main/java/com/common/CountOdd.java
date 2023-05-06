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
public class CountOdd {
    public int countOdds(int low, int high) {
        int nOddHigh = high % 2 == 0 ? high/2 : high/2 + 1;
        int nOddLow =  low % 2 == 0 ? low/2 : low/2 + 1;
        
        return low % 2 == 0 ? nOddHigh - nOddLow : nOddHigh - nOddLow + 1;
    }
}
