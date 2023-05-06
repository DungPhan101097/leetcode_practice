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
public class SortedListToBST {
    
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        
        if (head.next == null) {
            return new TreeNode(head.val, null, null);
        }
        
        ListNode slow = head;
        ListNode fast = head.next.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode res = new TreeNode(slow.next.val);
        ListNode rightHalf = slow.next.next;
        
        slow.next = null;
        res.left = sortedListToBST(head);
        res.right = sortedListToBST(rightHalf);
        
        return res;        
    }
    
    public static void main(String[] args) {
        int[] arr = {-10,-3,0,5,9};
        
        ListNode head = new ListNode(arr[0]);
        ListNode tmp = head;
        for (int i = 1; i < arr.length; i++) {
            tmp.next = new ListNode(arr[i]);
            tmp = tmp.next;
        }
        
        TreeNode root = new SortedListToBST().sortedListToBST(head);
        
        int a = 1;
        
    }
}
