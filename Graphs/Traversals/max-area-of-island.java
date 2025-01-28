//Problem: https://leetcode.com/problems/max-area-of-island/

import java.util.*;
import java.io.*;

class AreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length, area=0;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            Arrays.fill(visited[i], false);
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==1 && !visited[i][j]) {
                    visited[i][j] = true;
                    int[] sum = new int[]{1};
                    numberOfIsland(i,j,grid,visited,sum);
                    area = Math.max(sum[0], area);
                }
            }
        }
        return area;
    }
    
    public void numberOfIsland(int pos1, int pos2, int[][]grid, boolean[][] visited, int[] sum) {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int n = grid.length, m = grid[0].length;
        for(int i=0; i<4; i++) {
            int x = pos1 + dx[i];
            int y = pos2 + dy[i];
            if(x>=0 && x<n && y>=0 && y<m && grid[x][y]==1 && !visited[x][y]) {
                sum[0]+=1;
                visited[x][y] = true;
                numberOfIsland(x,y,grid,visited,sum);
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
            {0,1,1,0},{0,0,1,1},{1,0,0,0},{0,1,1,1}
        };
        AreaOfIsland island = new AreaOfIsland();
        System.out.println(island.maxAreaOfIsland(grid));
    }
}