/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author dungptm2
 */
public class JumpGame4 {
    
    //6,1,9
    public int minJumps(int[] arr) {        
        int n = arr.length;
        int step = 0;
        
        if (n == 1) {
            return 0;
        }
        
        Map<Integer, List<Integer>> map = new HashMap();
        
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        
        while (!q.isEmpty()) {
            step++;
            int lenSlide = q.size();
            
            for (int i = 0 ; i< lenSlide; i++) {
                Integer curIndex = q.poll();
                Integer curValue = arr[curIndex];
                
                if (curIndex + 1 < n && map.containsKey(arr[curIndex + 1])) {
                    if (curIndex + 1 == n - 1) {
                        return step;
                    }
                    q.offer(curIndex + 1);
                }
                
                if (curIndex -1 >=0 && map.containsKey(arr[curIndex - 1])) {
                    q.offer(curIndex - 1);
                }
                
                List<Integer> lsIndexJump = map.getOrDefault(curValue, Collections.EMPTY_LIST);
                for (int indexJump : lsIndexJump) {
                    if (indexJump == n -1) {
                        return step;
                    }
                    if (indexJump != curIndex && map.containsKey(arr[indexJump])) {
                        q.offer(indexJump);
                    }
                }
                
                map.remove(curValue);                
            }
        }
        
        return step;        
    }
    
    public static void main(String[] args) {
        
        int[] arr = {6, 1, 9};
        
        int minStep = new JumpGame4().minJumps(arr);
        
        System.out.println("ret = " + minStep);
        
        System.exit(0);
    }
    
}
