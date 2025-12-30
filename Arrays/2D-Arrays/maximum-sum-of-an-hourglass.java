//Problem: https://leetcode.com/problems/maximum-sum-of-an-hourglass/description/




import java.io.*;
import java.util.*;

class HourGlass {
    public int maxSum(int[][] grid) {
        int sum = 0, n = grid.length, m = grid[0].length;
        for(int i=0; i<=n-3; i++) {
            for(int j=0; j<=m-3; j++) {
                sum = Math.max(sum, hourGlassSum(grid, i, j));
            }
        }
        return sum;
    }

    public int hourGlassSum(int[][] grid, int r, int c) {
        int sum = 0;
        sum+=grid[r][c] + grid[r][c+1] + grid[r][c+2];
        sum+=grid[r+2][c] + grid[r+2][c+1] + grid[r+2][c+2];
        sum+=grid[r+1][c+1];
        return sum;
    }
}
class Main {
    public static void main(String[] args) {
        HourGlass mat = new HourGlass();
        int[][] grid = {{6,2,1,3},{4,2,1,5},{9,2,8,7},{4,1,2,9}};
        System.out.println(mat.maxSum(grid));
        
        int[][] grid1 = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(mat.maxSum(grid1));
    }
}