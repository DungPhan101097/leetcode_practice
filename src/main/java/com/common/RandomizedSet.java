/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author dungptm2
 */
public class RandomizedSet {
    
    private final Map<Integer, Integer> dataMap;
    private final List<Long> dataList;
    
    private Random random = new Random();
    
    public RandomizedSet() {
        dataMap = new HashMap<>();
        dataList = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (dataMap.containsKey(val)) {
            return false;
        }
        dataMap.put(val, dataMap.size());
        dataList.add((long)val);
        return true;
    }

    public boolean remove(int val) {
        if (dataMap.containsKey(val)) {
            Integer rmIndex = dataMap.remove(val);
            dataList.set(rmIndex, Long.MIN_VALUE);
            return true;
        }
        return false;
    }

    public int getRandom() {
        int size = dataList.size();
        
        while (true) {
            int randomIndex = random.nextInt(size);
            if (dataList.get(randomIndex) != Long.MIN_VALUE) {
                return dataList.get(randomIndex).intValue();
            }
        }
        
    }
    
    public static void main(String[] args) {
        Random random = new Random();
        List<Long> dataList = new ArrayList<>();
        
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                dataList.add(Long.MIN_VALUE);
            } else {
                dataList.add((long) i);
            }
            
        }

        
        while (true) {
            int randomIndex = random.nextInt(50);
            if (dataList.get(randomIndex) != Long.MIN_VALUE) {
                System.out.println("random " + randomIndex + " " + dataList.get(randomIndex).intValue());
                return;
            }
        }
    }
}
