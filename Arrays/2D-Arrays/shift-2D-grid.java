//Problem: https://leetcode.com/problems/shift-2d-grid/description/





import java.io.*;
import java.util.*;

class Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int m=grid.length, n=grid[0].length;
        while(k!=0) {
            int[][] mat = applyShift(grid, m, n);
            grid=mat;
            k--;
        }
        for(int i=0; i<m; i++) {
            List<Integer> arr = new ArrayList<>();
            for(int j=0; j<n; j++) {
                arr.add(grid[i][j]);
            }
            ans.add(arr);
        }
        return ans;
    }

    public int[][] applyShift(int[][] grid, int m, int n) {
        int[][] mat = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i==m-1 && j==n-1) {
                    mat[0][0] = grid[i][j];
                } else if(j==n-1) {
                    mat[i+1][0] = grid[i][n-1];
                } else {
                    mat[i][j+1] = grid[i][j];
                }
            }
        }
        return mat;
    }
    
    public void display(List<List<Integer>> ans) {
        for(int i=0; i<ans.size(); i++) {
            for(int j=0; j<ans.get(0).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Shift2DGrid mat = new Shift2DGrid();
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        List<List<Integer>> ans = mat.shiftGrid(grid, 1);
        mat.display(ans);
        
        int[][] grid1 = {{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
        List<List<Integer>> ans1 = mat.shiftGrid(grid1, 4);
        mat.display(ans1);
        
        int[][] grid2 = {{1,2,3},{4,5,6},{7,8,9}};
        List<List<Integer>> ans2 = mat.shiftGrid(grid2, 9);
        mat.display(ans2);
    }
}