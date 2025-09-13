//Problem: https://leetcode.com/problems/find-the-width-of-columns-of-a-grid/description/






import java.io.*;
import java.util.*;

class WidthOfColumn {
    public int[] findColumnWidth(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            int maxLength = 0;
            for(int j=0; j<m; j++) {
                String val = String.valueOf(grid[j][i]);
                maxLength = Math.max(maxLength, val.length());
            }
            ans[i] = maxLength;
        }
        return ans;
    }
    
    public void display(int[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        WidthOfColumn matrix = new WidthOfColumn();
        int[][] grid = {{1},{22},{333}};
        int[] ans = matrix.findColumnWidth(grid);
        matrix.display(ans);
        
        int[][] grid1 = {{-15,1,3},{15,7,12},{5,6,-2}};
        int[] ans1 = matrix.findColumnWidth(grid1);
        matrix.display(ans1);
        
    }
}