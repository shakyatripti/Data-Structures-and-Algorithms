//Problem: https://leetcode.com/problems/equal-sum-grid-partition-i/description/




import java.io.*;
import java.util.*;

class EqualSumGridPartition {
    public boolean canPartitionGrid(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        long totalSum = 0, vertical = 0, horizontal = 0;
        long[] col = new long[n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                totalSum+=grid[i][j];
                col[j]+=grid[i][j];
            }
        }
        
        for(int i=0; i<m-1; i++) {
            for(int j=0; j<n; j++) {
                horizontal+=grid[i][j];
            }
            if(horizontal*2==totalSum) {
                return true;
            }
        }
        
        for(int i=0; i<n-1; i++) {
            vertical+=col[i];
            if(vertical*2==totalSum) {
                return true;
            }
        }
        
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        EqualSumGridPartition obj = new EqualSumGridPartition();
        int[][] grid = {
            {1,4},
            {2,3}
        };
        System.out.println(obj.canPartitionGrid(grid));
        
        int[][] grid1 = {
            {1,3},
            {2,4}
        };
        System.out.println(obj.canPartitionGrid(grid1));
        
        int[][] grid2 = {
            {1,2,3,4}, 
            {2,9,8,9}
        };
        System.out.println(obj.canPartitionGrid(grid2));
    }
}