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
public class SearchInBST {
    
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode ret = doSearchBST(root, val);
        
        return ret;
    }
     
    public TreeNode doSearchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        
        if (root.val == val) {
            return root;
        }
        
        if (val < root.val) {
            return doSearchBST(root.left, val);
        } else {
            return doSearchBST(root.right, val);
        }
    }
    
    public static void main(String[] args) {
        int[] array = new int[] {4,2,7,1,3};
        TreeNode root = TreeNode.arrayToTree(array);
        
        TreeNode ret = new SearchInBST().searchBST(root, 2);
        
        System.out.println("ret = " + ret);
        
        System.exit(0);
    }
}
