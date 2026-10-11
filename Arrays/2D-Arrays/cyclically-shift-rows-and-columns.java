//Problem: https://leetcode.com/problems/cyclically-shift-rows-and-columns/description/




import java.io.*;
import java.util.*;


class Matrix {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int[][] ans = new int[n][n];
        int[][] result = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int r = (j - rowShift[i] + n) % n;
                ans[i][r] = grid[i][j];
            }
        }

        for(int j=0; j<n; j++) {
            for(int i=0; i<n; i++) {
                int r = (i - colShift[j] + n) % n;
                result[r][j] = ans[i][j];
            }
        }
        return result;
    }
    
    public void display(int[][] ans) {
        for(int i=0; i<ans.length; i++) {
            for(int j=0; j<ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Matrix mat = new Matrix();
        int[][] grid = {{1,2},{3,4}};
        int[] rowShift = {1,0};
        int[] colShift = {0,1};
        int[][] ans = mat.cyclicShift(2, grid, rowShift, colShift);
        mat.display(ans);
        
        int[][] grid1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[] rowShift1 = {1,2,0};
        int[] colShift1 = {2,2,1};
        int[][] ans1 = mat.cyclicShift(3, grid1, rowShift1, colShift1);
        mat.display(ans1);
    }
}