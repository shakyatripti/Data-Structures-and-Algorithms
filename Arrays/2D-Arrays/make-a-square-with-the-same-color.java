//Problem: https://leetcode.com/problems/make-a-square-with-the-same-color/description/




import java.io.*;
import java.util.*;

class SameColorSquare {
    public boolean canMakeSquare(char[][] grid) {
        if(findInSquareMatrix(grid, 0, 0) || findInSquareMatrix(grid, 0, 1) || findInSquareMatrix(grid, 1, 0) || findInSquareMatrix(grid, 1, 1)) {
            return true;
        }
        return false;
    }

    public boolean findInSquareMatrix(char[][] grid, int r, int c) {
        int black=0, white=0;
        for(int i=r; i<=r+1; i++) {
            for(int j=c; j<=c+1; j++) {
                if(grid[i][j]=='W') {
                    white++;
                } else {
                    black++;
                }
            }
        }
        int diff = Math.abs(white - black);
        if(diff==0) {
            return false;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        SameColorSquare sq = new SameColorSquare();
        char[][] grid = {{'B','W','B'},{'B','W','W'},{'B','W','B'}};
        System.out.println(sq.canMakeSquare(grid));

        char[][] grid1 = {{'B','W','B'},{'W','B','W'},{'B','W','B'}};
        System.out.println(sq.canMakeSquare(grid1));

        char[][] grid2 = {{'B','W','B'},{'B','W','W'},{'B','W','W'}};
        System.out.println(sq.canMakeSquare(grid2));
    }
}