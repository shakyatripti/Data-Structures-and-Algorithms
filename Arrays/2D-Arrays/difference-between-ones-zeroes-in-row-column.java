//Problem: https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/description/




import java.io.*;
import java.util.*;

class DiffOnesAndZeroes {
    public int[][] onesMinusZeros(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[] onesRow = new int[m];
        int[] onesCol = new int[n];
        int[] zeroesRow = new int[m];
        int[] zeroesCol = new int[n];
        for(int i=0; i<m; i++) {
            int ones = 0;
            for(int j=0; j<n; j++) {
                if(grid[i][j]==1) {
                    ones++;
                }
            }
            onesRow[i] = ones;
            zeroesRow[i] = m - ones;
        }

        for(int i=0; i<n; i++) {
            int ones = 0;
            for(int j=0; j<m; j++) {
                if(grid[j][i]==1) {
                   ones++;
                }
            }
            onesCol[i] = ones;
            zeroesCol[i] = n - ones;
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                grid[i][j] = onesRow[i] + onesCol[j] - zeroesRow[i] - zeroesCol[j];
            }
        }
        return grid;
    }
    
    public void display(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(grid[i][j] +  " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


class Main {
    public static void main(String[] args) {
        DiffOnesAndZeroes matrix = new DiffOnesAndZeroes();
        int[][] grid = {{0,1,1},{1,0,1},{0,0,1}};
        int[][] ans = matrix.onesMinusZeros(grid);
        matrix.display(ans);
        
        int[][] grid1 = {{1,1,1},{1,1,1}};
        int[][] ans1 = matrix.onesMinusZeros(grid1);
        matrix.display(ans1);
        
        int[][] grid2 = {{0,1},{1,0},{0,0}};
        int[][] ans2 = matrix.onesMinusZeros(grid2);
        matrix.display(ans2);
    }
}