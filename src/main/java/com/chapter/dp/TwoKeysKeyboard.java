/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chapter.dp;

/**
 *
 * @author dungptm2
 */
public class TwoKeysKeyboard {
    
    public int minSteps(int n) {
        int totalStep = 0;
        
        while (n != 1) {
            int i;
            for (i = 2; i < n; i++) {
                if (n%i == 0) {
                    totalStep += i;
                    n = n/i;
                    break;
                }
            }
            if (i == n) {
                totalStep += n;
                break;
            }
        }        
        return totalStep;
    }
    
    public static void main(String[] args) {
        
        int n = 1;
        
        int ret = new TwoKeysKeyboard().minSteps(n);
        
        System.out.println("ret = " + ret);
        
        System.exit(0);
    }
    
}
