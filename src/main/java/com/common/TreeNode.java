/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common;

/**
 *
 * @author dungptm2
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    public static TreeNode arrayToTree(int array[]) {
        return arrayToTree(array, 0);
    }

    public static TreeNode arrayToTree(int array[], int index) {
        if (index >= array.length) {
            return null;
        }
        return new TreeNode(array[index], arrayToTree(array, index * 2 + 1), arrayToTree(array, index * 2 + 2));
    }
}
