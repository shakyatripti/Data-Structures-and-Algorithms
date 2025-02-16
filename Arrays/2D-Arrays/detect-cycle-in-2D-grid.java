//Problem: https://leetcode.com/problems/detect-cycles-in-2d-grid/description/


//This solution beats 45% and if we use Stack instead of Queue it will beat only 11%.
import java.util.*;
import java.io.*;

class DetectCycleInGrid {
    public boolean containsCycle(char[][] grid) {
        int n=grid.length, m=grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(isCyclic(grid,visited,i,j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isCyclic(char[][] grid, boolean[][] visited, int r, int c) {
        int n = grid.length, m=grid[0].length;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int row = pos[0];
            int col = pos[1];
            if(visited[row][col]) {
                return true;
            }
            for(int i=0; i<4; i++) {
                int x = dx[i] + row;
                int y = dy[i] + col;
                if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==grid[r][c] && !visited[x][y]) {
                    q.add(new int[]{x,y});
                }
            }
            visited[row][col] = true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        char[][] charGrid = {{'a','a','a','a'},{'a','b','b','a'},{'a','b','b','a'},{'a','a','a','a'}};
        DetectCycleInGrid grid = new DetectCycleInGrid();
        System.out.println(grid.containsCycle(charGrid));
    }
}