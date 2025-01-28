//Problem: https://leetcode.com/problems/number-of-islands/description/

import java.util.*;
import java.io.*;

class NumberOfIslands {
    public int numIsLands(char[][] grid) {
        int n = grid.length, m = grid[0].length, count=0;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            Arrays.fill(visited[i], false);
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]=='1' && !visited[i][j]) {
                    visited[i][j] = true;
                    count++;
                    connectedIslands(i,j,grid,visited);
                }
            }
        }
        return count;
    }
    
    public void connectedIslands(int pos1, int pos2, char[][]grid, boolean[][] visited) {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int n = grid.length, m = grid[0].length;
        for(int i=0; i<4; i++) {
            int x = pos1 + dx[i];
            int y = pos2 + dy[i];
            if(x>=0 && x<n && y>=0 && y<m && grid[x][y]=='1' && !visited[x][y]) {
                visited[x][y] = true;
                connectedIslands(x,y,grid,visited);
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        char[][] grid = new char[][] {
            {'0','1','1','0'},{'0','1','0','0'},{'1','1','0','0'},{'0','0','0','0'}
        };
        NumberOfIslands island = new NumberOfIslands();
        System.out.println(island.numIsLands(grid));
    }
}