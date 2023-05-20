/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chapter.recursion;

/**
 *
 * @author dungptm2
 */
public class Search2DMatrixII {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int ncol = matrix.length;
        int nrow = matrix[0].length;
        return doSearchMatrix(matrix, 0, nrow-1, 0, ncol-1, target);
    }
    
    // 3 4 5 6
    private boolean doSearchMatrix(int[][] matrix, int iStartCol, int iEndCol, 
            int iStartRow, int iEndRow, int target) {
        if (iStartCol > iEndCol || iStartRow > iEndRow) {
            return false;
        }

        if (iStartCol == iEndCol && iStartRow == iEndRow) {
            return matrix[iStartRow][iStartCol] == target;
        }
        
        int iMidCol = (iStartCol + iEndCol) / 2;
        
        for (int i = iStartRow; i <= iEndRow; i++) {
            if (target == matrix[i][iMidCol]) {
                return true;
            } else if (target > matrix[i][iMidCol]) {
                // ignore left
                if (i + 1 <= iEndRow && target < matrix[i+1][iMidCol]) {
                    boolean searchTopRight = doSearchMatrix(matrix, iMidCol+1, iEndCol, iStartRow, i, target);
                    if (searchTopRight) {
                        return searchTopRight;
                    }
                    return doSearchMatrix(matrix, iStartCol, iMidCol-1, i+1, iEndRow, target);
                }
            }
        }
        
        if (target > matrix[iEndRow][iMidCol]) {
            return doSearchMatrix(matrix, iMidCol + 1, iEndCol, iStartRow, iEndRow, target);
        } 
        if (target < matrix[iStartRow][iMidCol]) {
            return doSearchMatrix(matrix, iStartCol, iMidCol - 1, iStartRow, iEndRow, target);         
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        
        int[][] matrix = new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        int[][] matrix = new int[][] {{1,1}};
        
        boolean ret = new Search2DMatrixII().searchMatrix(matrix, 5);
        
        System.out.println("ret = " + ret);
        
        System.exit(0);
    }
}
