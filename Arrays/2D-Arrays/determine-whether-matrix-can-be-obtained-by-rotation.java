//Problem: https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/description/




import java.io.*;
import java.util.*;

class RotationOfMatrix {
    public boolean isSame(int[][] mat, int[][] target) {
        int count = 0, n=mat.length;
        while(count < 4) {
            int[][] grid = rotatedMatrix(mat);
            int flag=0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(grid[i][j]!=target[i][j]) {
                        flag=-1;
                    }
                }
            }
            if(flag==0) {
                return true;
            }
            mat = grid;
            count++;
        }
        return false;
    }

    public int[][] rotatedMatrix(int[][] mat) {
        int n=mat.length;
        int[][] grid = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=n-1; j>=0; j--) {
                grid[i][n-j-1] = mat[j][i];
            }
        }
        return grid;
    }
}

class Main {
    public static void main(String[] args) {
        RotationOfMatrix grid = new RotationOfMatrix();
        int[][] mat = {{0,1},{1,0}};
        int[][] target = {{1,0},{0,1}};
        System.out.println(grid.isSame(mat, target));
        
        int[][] mat1 = {{0,1},{1,1}};
        int[][] target1 = {{1,0},{0,1}};
        System.out.println(grid.isSame(mat1, target1));
        
        int[][] mat2 = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] target2 = {{1,1,1},{0,1,0},{0,0,0}};
        System.out.println(grid.isSame(mat2, target2));
    }
}