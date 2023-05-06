/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dungptm2
 */
public class FruitBasket {
    
    public int totalFruit(int[] fruits) {
        int max = 0;
        int totalFruit = fruits.length;
        List<Integer> types = new ArrayList<>(2);
        
        for (int i = 0; i< totalFruit; i++) {
            int curmax = 0;
            for (int j = i; j < totalFruit; j++) {
                if (types.size() < 2) {
                    types.add(fruits[j]);
                    curmax++;
                } else if (types.contains(fruits[j])) {
                    curmax++;
                } else {
                    i = j - 1;
                    max = Math.max(curmax, max);
                    break;
                }
                
                if (j == totalFruit - 1) {
                    return max;
                }
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        int[] fruits = {1,2,1};
        int totalFruit = new FruitBasket().totalFruit(fruits);
        
        System.out.println("ret = " + totalFruit);
        
        System.exit(0);
    }
    
}
