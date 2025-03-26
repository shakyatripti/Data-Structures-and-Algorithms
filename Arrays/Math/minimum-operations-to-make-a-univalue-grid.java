//Problem: https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description/


import java.io.*;
import java.util.*;

class MinOpsToMakeUnivalueGrid {
    public int minimumOperations(int[][] grid, int x) {
        int[] arr = new int[grid.length * grid[0].length];
        int index = 0, ans=0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                arr[index++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int target = arr[arr.length/2];
        for(int num: arr) {
            if(num%x != target%x) {
                return -1;
            }
            ans+=Math.abs((target-num)/x);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] grid = {{1,2},{3,4}};
        MinOpsToMakeUnivalueGrid univalueGrid = new MinOpsToMakeUnivalueGrid();
        System.out.println(univalueGrid.minimumOperations(grid, 2));
        
        int[][] grid1 = {{2,4},{6,8}};
        System.out.println(univalueGrid.minimumOperations(grid1, 2));
        
        int[][] grid3 = {{1,5},{2,3}};
        System.out.println(univalueGrid.minimumOperations(grid3, 1));
        
    }
}