/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chapter.recursion;

import com.common.TreeNode;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dungptm2
 */
public class ValidateBST {
    private TreeNode MAX_NODE = null;
    
    public boolean isValidBST(TreeNode root) {
        boolean isValid = doValidBST(root);
        return isValid;
    }
    
    private boolean doValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean checkLeft = doValidBST(root.left);
        if (!checkLeft) {
            return false;
        }
        
        if (MAX_NODE == null) {
            MAX_NODE = root;
        } else {
            if (root.val > MAX_NODE.val) {
                MAX_NODE = root;
            } else {
                return false;
            }
        }
        
        return doValidBST(root.right);
    }
    
    public static void main(String[] args) {
        int[] a = new int[] {0,-1, 2};
        TreeNode root = TreeNode.arrayToTree(a);
        
        boolean ret = new ValidateBST().isValidBST(root);
        
        System.out.println("ret = " + ret);
        
        System.exit(0);
    }
}
