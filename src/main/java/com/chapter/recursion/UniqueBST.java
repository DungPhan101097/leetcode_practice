/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chapter.recursion;

import com.common.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dungptm2
 */
public class UniqueBST {
    
    public List<TreeNode> generateTrees(int n) {
        return doGenerateTrees(1, n);
    }
    
    private List<TreeNode> doGenerateTrees(int start, int end) {
        List<TreeNode> ret = new ArrayList<>();
        
        if (start > end) {
            ret.add(null);
            return ret;
        }
        
        for (int i = start; i <= end; i++) {            
            List<TreeNode> leftTrees = doGenerateTrees(start, i-1);
            List<TreeNode> rightTrees = doGenerateTrees(i+1, end);
            
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode curRoot = new TreeNode(i);
                    curRoot.left = leftTree;
                    curRoot.right = rightTree;
                    ret.add(curRoot);
                }
            }
            
         }
        
        return ret;
    }
    
    public static void main(String[] args) {
        
        List<TreeNode> ret = new UniqueBST().generateTrees(3);
                
        System.out.println("ret = " + ret);
        
        System.exit(0);
    }
            
    
}
