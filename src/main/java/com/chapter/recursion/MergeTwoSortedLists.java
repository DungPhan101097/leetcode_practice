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
public class MergeTwoSortedLists {
    
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode retHead = null;
        ListNode iterNode = null;

        while (list1 != null && list2 != null) {
            ListNode curNode = list1.val < list2.val ? list1 : list2;
            if (iterNode == null) {
                iterNode = curNode;
                retHead = iterNode;
            } else {
                iterNode.next = curNode;
                iterNode = curNode;
            }

            if (list1.val < list2.val) {
                list1 = list1.next;
            } else {
                list2 = list2.next;
            }
        }
        
        if (list1 != null) {
            iterNode.next = list1;
        } else if (list2 != null) {
            iterNode.next = list2;
        }

        return retHead;
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return doMergeList(list1, list2);
    }
    
    private ListNode doMergeList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }
        
        if (list1.val < list2.val) {
            ListNode curNode = doMergeList(list1.next, list2);
            list1.next = curNode;
            return list1;
        } 
        
        ListNode curNode = doMergeList(list1, list2.next);
        list2.next = curNode;
        return list2;
    }
    
    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 4, 10, 20, 21, 22, 34, 35};
        int[] b = new int[] {1, 3, 4};
        
        ListNode lsA = ListNode.fromArray(a);
        ListNode lsB = ListNode.fromArray(b);
        
        ListNode ret = new MergeTwoSortedLists().mergeTwoLists(lsA, lsB);
        
        System.exit(0);
    }
}
