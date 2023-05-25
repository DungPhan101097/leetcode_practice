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
public class InorderTraversalBT {
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        doInorderTraversal(root, result);
        
        return result;
    }
    
    private void doInorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        
        doInorderTraversal(root.left, result);
        result.add(root.val);
        doInorderTraversal(root.right, result);
    }
    
}
