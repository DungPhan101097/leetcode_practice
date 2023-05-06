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
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    
    public static ListNode fromArray(int[] array) {
        ListNode head = null;
        ListNode tmpNode = null;
        
        for (int a  : array) {
            if (tmpNode == null) {
                tmpNode = new ListNode(a);
                head = tmpNode;
            } else {
                ListNode curNode = new ListNode(a);
                tmpNode.next = curNode;
                tmpNode = curNode;
            }
        }
        
        return head;
    }
    
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3};
        
        ListNode head = ListNode.fromArray(array);
        
        System.exit(0);
    }
}
