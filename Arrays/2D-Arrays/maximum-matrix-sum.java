//Problem: https://leetcode.com/problems/maximum-matrix-sum/description/





import java.io.*;
import java.util.*;

class MatrixSum {
    public long maxSum(int[][] matrix) {
        long totalSum = 0, minVal = Integer.MAX_VALUE, negNum = 0;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                totalSum+=Math.abs(matrix[i][j]);
                minVal = Math.min(minVal, Math.abs(matrix[i][j]));
                if(matrix[i][j] <= 0) {
                    negNum++;
                }
            }
        }

        if(negNum%2!=0) {
            return totalSum - 2*minVal;
        }
        return totalSum;
    }
}

class Main {
    public static void main(String[] args) {
        MatrixSum mat = new MatrixSum();
        int[][] matrix = {{1,-1},{-1,1}};
        System.out.println(mat.maxSum(matrix));
        
        int[][] matrix1 = {{1,2,3},{-1,-2,-3},{1,2,3}};
        System.out.println(mat.maxSum(matrix1));
        
        int[][] matrix2 = {{-1,0,-1},{-2,1,3},{3,2,2}};
        System.out.println(mat.maxSum(matrix2));
        
        int[][] matrix3 = {{2,9,3},{5,4,-4},{1,7,1}};
        System.out.println(mat.maxSum(matrix3));
    }
}