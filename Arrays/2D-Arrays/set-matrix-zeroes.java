//Problem: https://leetcode.com/problems/set-matrix-zeroes/description/




import java.io.*;
import java.util.*;

class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j]==0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(cols.contains(j) || rows.contains(i)) {
                    matrix[i][j]=0;
                }
            }
        }
    }
    
    public void display(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}

class Main {
    public static void main(String[] args) {
        SetMatrixZeroes mat = new SetMatrixZeroes();
        int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};
        mat.setZeroes(matrix);
        mat.display(matrix);
        
        int[][] matrix1 = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        mat.setZeroes(matrix1);
        mat.display(matrix1);
    }
}