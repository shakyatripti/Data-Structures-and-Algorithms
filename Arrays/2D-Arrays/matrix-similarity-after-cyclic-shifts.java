//Problem: https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/description/




import java.io.*;
import java.util.*;

class MatrixCyclicShifts {
    public boolean areSimilar(int[][] mat, int k) {
        int m=mat.length, n=mat[0].length;  
        k=k%n;
        int[][] duplicate = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                duplicate[i][j] = mat[i][j];
            }
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i%2!=0) {
                    int index = (j+k)%n;
                    mat[i][index] = duplicate[i][j];
                } else {
                    int index = (j+n-k)%n;
                    mat[i][index] = duplicate[i][j];
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(duplicate[i][j]!=mat[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        MatrixCyclicShifts matrix = new MatrixCyclicShifts();
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(matrix.areSimilar(mat, 4));
        
        int[][] mat1 = {{1,2,1,2},{5,5,5,5},{6,3,6,3}};
        System.out.println(matrix.areSimilar(mat1, 2));
        
        int[][] mat2 = {{2,2},{2,2}};
        System.out.println(matrix.areSimilar(mat2, 3));
    }
}