//Problem: https://leetcode.com/problems/number-of-enclaves/description/

//1st solution: Using BFS
import java.util.*;
import java.io.*;

class NumberOfEnclaves {
    public int numEnclaves(int[][]grid) {
        int n=grid.length, m=grid[0].length, land=0;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            Arrays.fill(visited[i], false);
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if((i==0 || j==0 || i==n-1 || j==m-1) && !visited[i][j] && grid[i][j] == 1) {
                    visited[i][j] = true;
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()) {
            int[] dx={-1,0,1,0};
            int[] dy={0,1,0,-1};
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] t = q.poll();
                for(int j=0; j<4; j++) {
                    int x = dx[j] + t[0];
                    int y = dy[j] + t[1];
                    if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==1 && !visited[x][y]) {
                        visited[x][y]=true;
                        q.add(new int[]{x,y});
                    }
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j] && grid[i][j]==1) {
                    land++;
                }
            }
        }
        return land;
    }
}

class Main {
    public static void main(String[] args) {
         int[][] grid = new int[][]{
             {0,0,0,0},
             {0,1,1,0},
             {0,0,1,0},
             {1,0,0,0}
         };
         NumberOfEnclaves enclaves = new NumberOfEnclaves();
         System.out.println(enclaves.numEnclaves(grid));
    }
}

//2nd Solution: Using DFS
import java.util.*;
import java.io.*;

class NumberOfEnclaves {
    public int numEnclaves(int[][]grid) {
        int n=grid.length, m=grid[0].length, land=0;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            Arrays.fill(visited[i], false);
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if((i==0 || j==0 || i==n-1 || j==m-1) && !visited[i][j] && grid[i][j] == 1) {
                    visited[i][j] = true;
                    findDfs(i,j,grid,visited);
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j] && grid[i][j]==1) {
                    land++;
                }
            }
        }
        return land;
    }
    
    public void findDfs(int sr, int sc, int[][] grid, boolean[][]visited) {
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        int a = grid.length, b=grid[0].length;
        for(int j=0; j<4; j++) {
            int x = dx[j] + sr;
            int y = dy[j] + sc;
            if(x>=0 && y>=0 && x<a && y<b && grid[x][y]==1 && !visited[x][y]) {
                visited[x][y]=true;
                findDfs(x,y,grid,visited);
            }
        }
        
    }
}

class Main {
    public static void main(String[] args) {
         int[][] grid = new int[][]{
             {0,0,1,1},
             {0,1,1,0},
             {0,0,1,0},
             {1,0,0,0}
         };
         NumberOfEnclaves enclaves = new NumberOfEnclaves();
         System.out.println(enclaves.numEnclaves(grid));
    }
}