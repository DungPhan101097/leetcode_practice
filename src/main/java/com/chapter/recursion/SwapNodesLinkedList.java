/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chapter.recursion;

import com.common.ListNode;

/**
 *
 * @author dungptm2
 */
public class SwapNodesLinkedList {

    public ListNode swapPairs(ListNode head) {
        doSwapPairs(head);
        return head;
    }

    private void doSwapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        int tmp = head.val;
        head.val = head.next.val;
        head.next.val = tmp;

        doSwapPairs(head.next.next);
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4};
        ListNode head = null;
        ListNode tmpHead = null;
        for (int i : a) {
            if (head == null) {
                head = new ListNode(i);
                tmpHead = head;
            } else {
                tmpHead.next = new ListNode(i);
                tmpHead = tmpHead.next;
            }
        }
        
        new SwapNodesLinkedList().swapPairs(head);

        // print 
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }

}
