//Problem:https://leetcode.com/problems/largest-local-values-in-a-matrix/description/



import java.io.*;
import java.util.*;

class Matrix {
    public int[][] largestLocal(int[][] grid) {
        int n=grid.length, p=0;
        int[][] ans = new int[n-2][n-2];
        for(int i=0; i<n-2; i++) {
            int rowStart = i, rowEnd = i+2, q=0;
            for(int j=0; j<n-2; j++) {
                int colStart = j, colEnd = j+2;
                int maxVal = maxElement(grid, rowStart, rowEnd, colStart, colEnd);
                ans[p][q] = maxVal;
                q++;
            }
            p++;
        }
        return ans;
    }

    public int maxElement(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd) {
        int res = 0;
        for(int i=rowStart; i<=rowEnd; i++) {
            for(int j=colStart; j<=colEnd; j++) {
                res = Math.max(res, grid[i][j]);
            }
        }
        return res;
    }
    
    public void display(int[][] ans) {
        for(int i=0; i<ans.length; i++) {
            for(int j=0; j<ans.length; j++) {
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
        int[][] grid = {{9,9,8,1}, {5,6,2,6}, {8,2,6,4}, {6,2,2,2}};
        int[][] ans = mat.largestLocal(grid);
        mat.display(ans);
        
        int[][] grid1 = {{1,1,1,1,1}, {1,1,1,1,1}, {1,1,2,1,1},
            {1,1,1,1,1}, {1,1,1,1,1}};
        int[][] ans1 = mat.largestLocal(grid1);
        mat.display(ans1);
    }
}