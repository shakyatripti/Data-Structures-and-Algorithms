//Problem: https://leetcode.com/problems/largest-magic-square/description/






import java.io.*;
import java.util.*;

class MagicSquare {
    public int largestSquare(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int k = Math.min(n, m);
        for(int p=k; p>=2; p--) {
            for(int i=0; i<=m-p; i++) {
                for(int j=0; j<=n-p; j++) {
                    if(isSumEqual(grid, i, j, i+p, j+p)) {
                        return p;
                    }
                }
            }
        }
        return 1;
    }

    public boolean isSumEqual(int[][] grid, int s1, int s2, int e1, int e2) {
        int d1 = 0, d2 = 0, size = e1-s1;
        for(int i=0; i<size; i++) {
            d1+=grid[s1+i][s2+i];
            d2+=grid[s1+i][s2+size-1-i];
        }

        for(int i=s1; i<e1; i++) {
            int r1=0;
            for(int j=s2; j<e2; j++) {
                r1+=grid[i][j];
            }
            if(r1!=d1 || d1!=d2) {
                return false;
            }
        }

        for(int i=s2; i<e2; i++) {
            int c1 = 0;
            for(int j=s1; j<e1; j++) {
                c1+=grid[j][i];
            }
            if(c1!=d1) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        MagicSquare sq = new MagicSquare();
        int[][] grid = {{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}};
        System.out.println(sq.largestSquare(grid));
        
        int[][] grid1 = {{5,1,3,1},{9,3,3,1},{1,3,3,8}};
        System.out.println(sq.largestSquare(grid1));
        
        int[][] grid2 = {{1}};
        System.out.println(sq.largestSquare(grid2));
    }
}