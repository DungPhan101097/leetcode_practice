/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chapter.recursion;

import com.common.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author dungptm2
 */
public class LevelOrderBT {

    public List<List<Integer>> levelOrder(TreeNode root) {        
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> siblingsNode = new ArrayDeque<>();
        
        result.add(Arrays.asList(root.val));
        if (root.left != null) {
            siblingsNode.add(root.left);
        }
        
        if (root.right != null) {
            siblingsNode.add(root.right);
        }

        doLevelOrder(result, siblingsNode);
        return result;
    }

    private void doLevelOrder(List<List<Integer>> result, Queue<TreeNode> siblingsNode) {        
        List<Integer> valsInLv = new ArrayList<>();
        Queue<TreeNode> childsOfSiblingsNode = new ArrayDeque<>();

        while (!siblingsNode.isEmpty()) {
            TreeNode siblingNode = siblingsNode.poll();
            if (siblingNode == null) {
                continue;
            }
            valsInLv.add(siblingNode.val);
            if (siblingNode.left != null) {
                childsOfSiblingsNode.add(siblingNode.left);
            }
            
            if (siblingNode.right != null) {
                childsOfSiblingsNode.add(siblingNode.right);
            }            
        }

        if (!valsInLv.isEmpty()) {
            result.add(valsInLv);
        }

        if (childsOfSiblingsNode.isEmpty()) {
            return;
        }
        
        doLevelOrder(result, childsOfSiblingsNode);
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 9, 20, 6, 8, 15, 7};

        TreeNode root = TreeNode.arrayToTree(a);

        List<List<Integer>> ret = new LevelOrderBT().levelOrder(root);

        System.out.println("ret = " + ret);

        System.exit(0);
    }

}
