//Problem: https://leetcode.com/problems/toeplitz-matrix/description/



import java.io.*;
import java.util.*;

class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[i].length; j++) {
                if(matrix[i][j]!=matrix[i-1][j-1]) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        ToeplitzMatrix matrix = new ToeplitzMatrix();
        int[][] grid = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        System.out.println(matrix.isToeplitzMatrix(grid));
        
        int[][] grid1 = {{1,2},{2,2}};
        System.out.println(matrix.isToeplitzMatrix(grid1));
    }
}