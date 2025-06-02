//Problem: https://leetcode.com/problems/convert-1d-array-into-2d-array/description/




import java.io.*;
import java.util.*;

class Convert1DTo2D {
    public int[][] convertArrayToMatrix(int[] original, int m, int n) {
        int[][] matrix = new int[m][n];
        if(m*n != original.length) {
            return new int[0][0];
        }
        int k=0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = original[k];
                k++;
            }
        }
        return matrix;
    }
    
    public void display(int[][] matrix) {
        if(matrix.length==0) {
            System.out.println("empty");
        }
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Convert1DTo2D matrix = new Convert1DTo2D();
        int[] original = {1,2,3,4};
        int[][] ans = matrix.convertArrayToMatrix(original, 2, 2);
        matrix.display(ans);
        
        int[] original2 = {1,2,3};
        int[][] ans1 = matrix.convertArrayToMatrix(original2, 1, 3);
        matrix.display(ans1);
        
        int[] original3 = {1,2};
        int[][] ans2 = matrix.convertArrayToMatrix(original3, 1, 1);
        matrix.display(ans2);
    }
}