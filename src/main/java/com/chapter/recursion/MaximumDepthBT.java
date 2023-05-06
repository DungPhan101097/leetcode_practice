/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chapter.recursion;

import com.common.TreeNode;

/**
 *
 * @author dungptm2
 */
public class MaximumDepthBT {
    
    public int maxDepth(TreeNode root) {
        return doMaxDepth(root);
    }
    
    private int doMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + Math.max(doMaxDepth(root.left), doMaxDepth(root.right));
    }
    
    public static void main(String[] args) {
        
        int[] array = new int[] {1,-1,2};
        TreeNode root = TreeNode.arrayToTree(array);
        
        int maxDepth = new MaximumDepthBT().maxDepth(root);
        
        System.out.println("ret = " + maxDepth);
        
        System.exit(0);
    }
        

}
