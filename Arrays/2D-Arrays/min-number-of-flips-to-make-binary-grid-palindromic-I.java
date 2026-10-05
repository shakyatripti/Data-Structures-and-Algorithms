//Problem: https://leetcode.com/problems/minimum-number-of-flips-to-make-binary-grid-palindromic-i/description/





import java.io.*;
import java.util.*;



class PalindromicBinaryGridI {
    public int minFlips(int[][] grid) {
        int m=grid.length, n=grid[0].length, rowFlips=0, colFlips=0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n/2; j++) {
                if(grid[i][j]!=grid[i][n-j-1]) {
                    rowFlips++;
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m/2; j++) {
                if(grid[j][i]!=grid[m-j-1][i]) {
                    colFlips++;
                }
            }
        }
        return Math.min(rowFlips, colFlips);
    }
}


class Main {
    public static void main(String[] args) {
        PalindromicBinaryGridI mat = new PalindromicBinaryGridI();
        int[][] grid = {{1,0,0}, {0,0,0}, {0,0,1}};
        System.out.println(mat.minFlips(grid));
        
        int[][] grid1 = {{0,1}, {0,1}, {0,0}};
        System.out.println(mat.minFlips(grid1));
        
        int[][] grid2 = {{1}, {0}};
        System.out.println(mat.minFlips(grid2));
    }
}