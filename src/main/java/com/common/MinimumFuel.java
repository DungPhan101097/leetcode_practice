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
public class MinimumFuel {
    
    private static long ans = 0;
    private static int s;

    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> graph = new ArrayList();
        s = seats;
        for (int i = 0; i < roads.length + 1; i++) {
            graph.add(new ArrayList());
        }
        for (int[] r : roads) {
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }
        dfs(0, 0, graph);
        return ans;
    }

    private int dfs(int i, int prev, List<List<Integer>> graph) {
        int people = 1;
        for (int x : graph.get(i)) {
            if (x == prev) {
                continue;
            }
            people += dfs(x, i, graph);
        }
        if (i != 0) {
            ans += (people + s - 1) / s;
        }
        return people;
    }
    
    public static void main(String[] args) {
        
        int[][] roads = new int[][] {{0,1},{0,2},{0,3}};
        int seats = 5;
        
        new MinimumFuel().minimumFuelCost(roads, seats);
        
        System.exit(0);
    }
    
}
