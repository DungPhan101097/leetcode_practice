/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chapter.recursion;

import java.util.Arrays;

/**
 *
 * @author dungptm2
 */
public class SortArray {
    
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        
        int pivot = nums.length/2;
        int[] leftArrays = sortArray(Arrays.copyOfRange(nums, 0, pivot));
        int[] rightArrays = sortArray(Arrays.copyOfRange(nums, pivot, nums.length));
        
        int[] result = new int[leftArrays.length + rightArrays.length];
        int i = 0;
        int j = 0;
        int k= 0;
        while (i < leftArrays.length && j < rightArrays.length) {
            if (leftArrays[i] < rightArrays[j]) {
                result[k++] = leftArrays[i++];
            } else {
                result[k++] = rightArrays[j++];
            }
        }
        
        while (i < leftArrays.length) {
            result[k++] = leftArrays[i++];
        }
        
        while (j < rightArrays.length) {
            result[k++] = rightArrays[j++];
        }
        
        return result;
    } 
    
    public static void main(String[] args) {
        int[] nums = new int[] {5,2,3,1};
        int[] ret = new SortArray().sortArray(nums);
        
        
        System.out.println("ret = " + ret);
        
        System.exit(0);
    }
}
