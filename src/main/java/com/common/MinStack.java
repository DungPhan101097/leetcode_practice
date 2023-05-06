/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common;

import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;

/**
 *
 * @author dungptm2
 */
public class MinStack {
    
    private final Stack<Integer> stack;
    private final TreeMap<Integer, Integer> treeMap;
    
    public MinStack() {
        stack = new Stack<>();
        treeMap = new TreeMap<>();
    }

    public void push(int val) {
        stack.push(val);
        treeMap.put(val, treeMap.getOrDefault(val, 0) + 1);
    }

    public void pop() {
        int val = stack.pop();
        
        int getMap = treeMap.get(val);
        if (getMap == 1) {
            treeMap.remove(val);
        } else {
            treeMap.put(val, getMap - 1);
        }
        
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return treeMap.firstKey();
    }
    
    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        
        treeMap.put(15, 0);
        treeMap.put(10, 0);
        treeMap.put(2, 0);
        treeMap.put(20, 0);
        treeMap.put(3, 0);
        treeMap.put(30, 0);
        treeMap.put(4, 0);
        treeMap.put(40, 0);
        treeMap.remove(2);

        System.out.println(treeMap.firstKey());
        
        System.exit(0);
    }
}
