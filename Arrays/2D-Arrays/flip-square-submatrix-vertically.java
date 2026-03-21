//Problem: https://leetcode.com/problems/flip-square-submatrix-vertically/description/





import java.io.*;
import java.util.*;

class ReverseSubmatrix {
    public int[][] flipSquare(int[][] grid, int x, int y, int k) {
        int m = grid.length, n = grid[0].length;
        for(int i=0; i<k/2; i++) {
            for(int j=y; j<y+k; j++) {
                int temp = grid[x+i][j];
                grid[x+i][j] = grid[x+k-1-i][j];
                grid[x+k-1-i][j] = temp;
            }
        }
        return grid;
    }
    
    public void display(int[][] grid) {
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        ReverseSubmatrix matrix = new ReverseSubmatrix();
        int[][] grid = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] ans = matrix.flipSquare(grid, 1, 0, 3);
        matrix.display(ans);
        
        int[][] grid1 = {{3,4,2,3},{2,3,4,2}};
        int[][] ans1 = matrix.flipSquare(grid1, 0, 2, 2);
        matrix.display(ans1);
        
        int[][] grid2 = {{6,16,14},{1,2,19},{14,17,15},{18,7,6},{14,12,5}};
        int[][] ans2 = matrix.flipSquare(grid2, 2, 1, 2);
        matrix.display(ans2);
    }
}