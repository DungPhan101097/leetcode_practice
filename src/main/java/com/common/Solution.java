/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common;

import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.function.ToIntFunction;
import javafx.util.Pair;

/**
 *
 * @author dungptm2
 */
public class Solution {
    
//"bxj##tw"
//"bxo#j##tw"
    public boolean backspaceCompare(String s, String t) {
        
        int i = s.length() - 1;
        int j = t.length() - 1;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int skip = 0;
        
        while (true) {
            
            while (i > 0 && sArray[i] == '#') {
                skip = 1;
                i--;
                while (i > 0 && sArray[i] == '#') {
                    skip ++;
                    i--;
                }
                i -= skip;
            }
            
            skip = 0;
            while (j > 0 && tArray[j] == '#') {
                skip = 1;
                j--;
                while (j > 0 && tArray[j] == '#') {
                    skip++;
                    j--;
                }
                j -= skip;
            }
            
            if (i >= 0 && j >= 0 && sArray[i] != tArray[j]) {
                return false;
            } else if (j < 0 && i < 0) {
                return true;
            }
            
            i--;
            j--;
            
        }
        
    }
    
    public static void main(String[] args) {

        Map map = new HashMap();
        Map map2 = new TreeMap();
        System.exit(0);
    }

   

}
