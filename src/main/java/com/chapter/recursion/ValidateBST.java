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
    private static int MAX_VAL = Integer.MIN_VALUE;
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }
        
        boolean isValid = doValidBST(root);
        return isValid;
    }
    
    private boolean doValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            if (root.val > MAX_VAL) {
                MAX_VAL = root.val;
                return true;
            }
            return false;
        }

        boolean checkLeft = doValidBST(root.left);
        if (checkLeft) {
            if (root.val > MAX_VAL) {
                MAX_VAL = root.val;
            } else {
                return false;
            }
            return doValidBST(root.right);
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        int[] a = new int[] {0,-1, 2};
        TreeNode root = TreeNode.arrayToTree(a);
        
        boolean ret = new ValidateBST().isValidBST(root);
        
        System.out.println("ret = " + ret);
        
        System.exit(0);
    }
}
