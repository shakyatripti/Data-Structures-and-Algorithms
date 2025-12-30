//Problem: https://leetcode.com/problems/magic-squares-in-grid/description/




import java.io.*;
import java.util.*;

class MagicSquares {
    public int countInside(int[][] grid) {
        int n=grid.length, m=grid[0].length, count=0;
        for(int i=0; i<=n-3; i++) {
            for(int j=0; j<=m-3; j++) {
                if(distinctNum(grid, i, j) && sameNum(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean distinctNum(int[][] grid, int r, int c) {
        Set<Integer> st = new HashSet<>();
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                int num = grid[r+i][c+j];
                if(num < 1 || num > 9 || st.contains(num)) {
                    return false;
                }
                st.add(num);
            }
        }
        return true;
    }

    public boolean sameNum(int[][] grid, int r, int c) {
        int sum = grid[r][c] + grid[r][c+1] + grid[r][c+2];
        for(int i=0; i<3; i++) {
            if((grid[r][c+i] + grid[r+1][c+i] + grid[r+2][c+i])!=sum) {
                return false;
            }
            if((grid[r+i][c] + grid[r+i][c+1] + grid[r+i][c+2])!=sum) {
                return false;
            }
        }

        if((grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2])!=sum) {
            return false;
        }

        if((grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c])!=sum) {
            return false;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        MagicSquares mat = new MagicSquares();
        int[][] grid = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
        System.out.println(mat.countInside(grid));
        
        int[][] grid1 = {{8}};
        System.out.println(mat.countInside(grid1));
    }
}