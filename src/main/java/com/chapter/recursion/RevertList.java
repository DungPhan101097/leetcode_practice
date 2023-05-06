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
public class RevertList {
    
    private static ListNode cacheHead = null;
    private static int totalSize = 0;
    private static int leftSwap = 0;
    public ListNode reverseList(ListNode head) {
        cacheHead = head;
        ListNode originHead = head;
        doReverseList(head);
        
        return originHead;
    }
    
    private void doReverseList(ListNode tail) {
        if (tail == null) {
            return;
        }
        
        ++totalSize;
        doReverseList(tail.next);
        
        if (leftSwap < totalSize / 2) {
            ++leftSwap;
            int tmp = cacheHead.val;
            cacheHead.val = tail.val;
            tail.val = tmp;
            cacheHead = cacheHead.next;
        }
    }
    
    //Input: head = [1->2->3->4->5]
    //Output: [5->4->3->2->1]
    public ListNode reverseList2(ListNode head) {
        ListNode currNode = head;
        ListNode preNode = null;
        
        while(currNode != null) {
            ListNode tmp = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = tmp;
        }
        
        return preNode;
    }
    
    public static void main(String[] args) {
        
        int[] a = new int[]{1, 2, 3, 4, 5};
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

        ListNode retHead = new RevertList().reverseList2(head);
        
        // print 
        while (retHead != null) {
            System.out.print(retHead.val);
            retHead = retHead.next;
        }
        
        
        System.exit(0);
    }
    
}
