//Problem: https://leetcode.com/problems/design-neighbor-sum-service/description/




import java.io.*;
import java.util.*;

class DesignNeighbor {
    HashMap<Integer, int[]> position = new HashMap<>();
    int[][] grid;
    int n = 0;
    public DesignNeighbor(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
               position.put(grid[i][j], new int[]{i,j});
            }
        }
    }
    
    public int adjacentSum(int value) {
        int sum = 0;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        int[] pos = position.get(value);
        int row = pos[0], col = pos[1];
        for(int i=0; i<4; i++) {
            int r = row + dx[i];
            int y = col + dy[i];
            if(r>=0 && y>=0 && r<n && y<n) {
                sum+=grid[r][y];
            }
        }
        return sum;
    }
    
    public int diagonalSum(int value) {
        int sum = 0;
        int[] dx = {-1,-1,1,1};
        int[] dy = {-1,1,1,-1};
        int[] pos = position.get(value);
        int row = pos[0], col = pos[1];
        for(int i=0; i<4; i++) {
            int r = row + dx[i];
            int y = col + dy[i];
            if(r>=0 && y>=0 && r<n && y<n) {
                sum+=grid[r][y];
            }
        }
        return sum;
    }
}


class Main {
    public static void main(String[] args) {
        int[][] grid = {{0,1,2},{3,4,5},{6,7,8}};
        DesignNeighbor matrix = new DesignNeighbor(grid);
        System.out.println(matrix.adjacentSum(1));
        System.out.println(matrix.adjacentSum(4));
        System.out.println(matrix.diagonalSum(4));
        System.out.println(matrix.diagonalSum(8));
        System.out.println("---");
        int[][] grid1 = {{1,2,0,3},{4,7,15,6},{8,9,10,11},{12,13,14,5}};
        DesignNeighbor matrix1 = new DesignNeighbor(grid1);
        System.out.println(matrix1.adjacentSum(15));
        System.out.println(matrix1.diagonalSum(9));
    }
}