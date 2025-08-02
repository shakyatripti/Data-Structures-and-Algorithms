//Problem: https://leetcode.com/problems/check-if-matrix-is-x-matrix/description/




import java.io.*;
import java.util.*;

class XMatrix {
    public boolean checkXMatrix(int[][] grid) {
        int n=grid.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i==j || i==n-j-1) {
                    if(grid[i][j]==0) {
                        return false;
                    }
                } else {
                    if(grid[i][j]!=0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}


class Main {
    public static void main(String[] args) {
        XMatrix matrix = new XMatrix();
        int[][] grid = {{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}};
        System.out.println(matrix.checkXMatrix(grid));
        
        int[][] grid1 = {{5,7,0},{0,3,1},{0,5,0}};
        System.out.println(matrix.checkXMatrix(grid1));
    }
}