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
public class Recursion {
    
    public void reverseString(char[] s) {
        doReverseString(0, s.length - 1, s);   
    }

    private void doReverseString(int l, int r, char[] s) {
        if (l > r) {
            return;
        }
        char cTmp = s[l];
        s[l] = s[r];
        s[r] = cTmp;
        doReverseString(++l, --r, s);
    }
    
    
    public static void main(String[] args) {
        char[] s = new char[] {'h','e','l','l','o'};
        new Recursion().reverseString(s);
        
        for (char c : s) {
            System.out.print(c);
        }
        System.exit(0);
    }
    
}
