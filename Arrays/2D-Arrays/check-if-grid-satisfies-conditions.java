//Problem: https://leetcode.com/problems/check-if-grid-satisfies-conditions/description/



import java.io.*;
import java.util.*;

class CheckGrid {
    public boolean satisfiesConditions(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int val = grid[i][j];
                if(i+1 <= m-1 && grid[i][j]!=grid[i+1][j]) {
                    return false;
                }
                if(j+1 <=n-1 && grid[i][j]==grid[i][j+1]) {
                    return false;
                }
            }
        }
        return true;
    }
}


class Main {
    public static void main(String[] args) {
        CheckGrid obj = new CheckGrid();
        int[][] grid = {{1,0,2},{1,0,2}};
        System.out.println(obj.satisfiesConditions(grid));
        
        int[][] grid2 = {{1,1,1},{0,0,0}};
        System.out.println(obj.satisfiesConditions(grid2));
        
        int[][] grid3 = {{1},{2},{3}};
        System.out.println(obj.satisfiesConditions(grid3));
    }
}