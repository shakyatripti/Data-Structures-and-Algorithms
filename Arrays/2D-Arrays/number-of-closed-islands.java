//Problem: https://leetcode.com/problems/number-of-closed-islands/description/


import java.io.*;
import java.util.*;

class NumberOfClosedIslands {
    public int closedIslands(int[][] grid) {
        int n=grid.length, m=grid[0].length, closed=0;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==0 && !visited[i][j] && connectedComponents(grid,visited, i,j,n,m)) {
                    closed++;
                }
            }
        }
        return closed;
    }
    
    public boolean connectedComponents(int[][] grid, boolean[][] visited, int r, int c, int n, int m) {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        boolean isClosed = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            for(int i=0; i<4; i++) {
                int x = dx[i] + pos[0];
                int y = dy[i] + pos[1];
                if(x < 0 || y < 0 || x>=n || y>=m) {
                    isClosed = false;
                } else if(grid[x][y]==0 && !visited[x][y]) {
                    q.add(new int[]{x,y});
                    visited[x][y] = true;
                }
            }
        }
        return isClosed;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,0,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        int[][] grid2 = {{1,1,0,1,1,1,1,1,1,1},{0,0,1,0,0,1,0,1,1,1},{1,0,1,0,0,0,1,0,1,0},{1,1,1,1,1,0,0,1,0,0},{1,0,1,0,1,1,1,1,1,0},{0,0,0,0,1,1,0,0,0,0},{1,0,1,0,0,0,0,1,1,0},{1,1,0,0,1,1,0,0,0,0},{0,0,0,1,1,0,1,1,1,0},{1,1,0,1,0,1,0,0,1,0}};
        NumberOfClosedIslands islands = new NumberOfClosedIslands();
        System.out.println(islands.closedIslands(grid));
        System.out.println(islands.closedIslands(grid2));
    }
}
