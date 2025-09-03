//Problem: https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/description/





import java.io.*;
import java.util.*;

class CellsWithOddValues {
    public int oddCells(int m, int n, int[][] indices) {
        int count =0;
        int[][] matrix = new int[m][n];
        for(int i=0; i<indices.length; i++) {
            int row = indices[i][0];
            int col = indices[i][1];
            for(int j=0; j<n; j++) {
                matrix[row][j]++;
            }
            for(int j=0; j<m; j++) {
                matrix[j][col]++;
            }
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j]%2!=0) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        CellsWithOddValues matrix = new CellsWithOddValues();
        int[][] indices = {{0,1},{1,1}};
        System.out.println(matrix.oddCells(2, 3, indices));
        
        int[][] indices1 = {{1,1},{0,0}};
        System.out.println(matrix.oddCells(2, 2, indices1));
    }
}