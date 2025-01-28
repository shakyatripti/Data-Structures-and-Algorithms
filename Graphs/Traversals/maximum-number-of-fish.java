//Problem: https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/description/

import java.util.*;
import java.io.*;

class MaximumNumberOfFish {
    public int findMaxFish(int[][] grid) {
        int n = grid.length, m = grid[0].length, fish=0;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            Arrays.fill(visited[i], false);
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] > 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    int[] sum = new int[]{grid[i][j]};
                    fishesCaught(i,j,grid,visited,sum);
                    fish = Math.max(sum[0], fish);
                }
            }
        }
        return fish;
    }
    
    public void fishesCaught(int pos1, int pos2, int[][]grid, boolean[][] visited, int[] sum) {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int n = grid.length, m = grid[0].length;
        for(int i=0; i<4; i++) {
            int x = pos1 + dx[i];
            int y = pos2 + dy[i];
            if(x>=0 && x<n && y>=0 && y<m && grid[x][y]>0 && !visited[x][y]) {
                sum[0]+=grid[x][y];
                visited[x][y] = true;
                fishesCaught(x,y,grid,visited,sum);
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
            {0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}
        };
        MaximumNumberOfFish fishes = new MaximumNumberOfFish();
        System.out.println(fishes.findMaxFish(grid));
    }
}