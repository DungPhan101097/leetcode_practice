/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author dungptm2
 */
public class ShortestPath {
    
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[][] g = new int[n][n];
        
        buildGraph(g, n, redEdges, blueEdges);
        
            Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 1});
        q.offer(new int[] {0, -1});
        int len = 0;
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        Set<String> visited = new HashSet<>();
        
        while (!q.isEmpty()) {
            int size = q.size();
            len++;
            for (int i = 0; i< size; i++) {
                int[] cur = q.poll();
                int node = cur[0];
                int color = cur[1];
                int oppoColor = -color;
                
                for (int j = 1; j<n; j++) {
                    if (g[node][j] == oppoColor 
                            || g[node][j] == 0) {
                        if (!visited.add(j  + "" + oppoColor)) 
                            continue;
                        q.offer(new int[] {j, oppoColor});                        
                        res[j] = Math.min(res[j], len);                        
                    }
                }
            }
        }
        
        for (int i = 0; i< n; i++) {
            if (res[i] == Integer.MAX_VALUE) {
                res[i] = -1;
            }
        }

        return res;                
    }
    
    // red 1, blue -1, both 0
    private void buildGraph(int[][] g, int n, int[][] redEdges, int[][] blueEdges) {
        for (int i = 0; i< n; i++) {
            Arrays.fill(g[i], -n);
        }
        
        for (int i = 0; i < redEdges.length; i++) {
            int from = redEdges[i][0];
            int to = redEdges[i][1];
            g[from][to] = 1;
        }
        
        for (int i = 0; i < blueEdges.length; i++) {
            int from = blueEdges[i][0];
            int to = blueEdges[i][1];
            g[from][to] = g[from][to] == 1 ? 0 : -1;
        }
    }
    
    
    
    public static void main(String[] args) {
        
        int[][] redEdges = {{2,1},{1,2}};
        int[][] blueEdges = {{1,0}};
        int n = 3;
        
        
        int[] res = new ShortestPath().shortestAlternatingPaths(n, redEdges, blueEdges);
        
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }
        
        System.exit(0);
    }
    
}
