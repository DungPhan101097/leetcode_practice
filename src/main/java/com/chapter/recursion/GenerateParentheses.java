/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chapter.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dungptm2
 */
public class GenerateParentheses {
    
    private List<String> result = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        doGenerateParenthesis(n, "", 0, 0);
        
        return result;
    }
    
    private void doGenerateParenthesis(int n, String current, int open, int close) {
        if (current.length() >= n*2) {
            result.add(current);
            return;
        }
        
        if (open < n) {
            doGenerateParenthesis(n, current + "(", open+1, close);
        }
        
        if (open > close) {
            doGenerateParenthesis(n, current + ")", open, close+1);
        }
    }
    
    public static void main(String[] args) {
        List<String> result = new GenerateParentheses().generateParenthesis(1);
        
        System.out.println("ret = " + result);
        
        System.exit(0);
    }
}
