//Problem: https://leetcode.com/problems/count-sub-islands/description/





import java.io.*;
import java.util.*;

class CountSubIslands {
    int[] dx = {0,1,0,-1};
    int[] dy = {-1,0,1,0};
    public int count(int[][] grid1, int[][] grid2) {
        int countIslands=0, m=grid2.length, n=grid2[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid2[i][j]==1 && isSubIslands(grid1, grid2, i, j, m, n)) {
                    countIslands++;
                }
            }
        }
        return countIslands;
    }
    
    public boolean isSubIslands(int[][] grid1, int[][] grid2, int row, int col, int m, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        grid2[row][col]=-1;
        boolean res = true;
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            if(grid1[pos[0]][pos[1]] !=1) {
                res = false;
            }
            for(int i=0; i<4; i++) {
                int x = pos[0] + dx[i];
                int y = pos[1] + dy[i];
                if(x>=0 && y>=0 && x<m && y<n && grid2[x][y]==1) {
                    q.add(new int[]{x,y});
                    grid2[x][y]=-1;
                }
            }
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        CountSubIslands islands = new CountSubIslands();
        int[][] grid1 = {
            {1,1,1,0,0},
            {0,1,1,1,1},
            {0,0,0,0,0},
            {1,0,0,0,0},
            {1,1,0,1,1}
        };
        int[][] grid2 = {
            {1,1,1,0,0},
            {0,0,1,1,1},
            {0,1,0,0,0},
            {1,0,1,1,0},
            {0,1,0,1,0}
        };
        System.out.println(islands.count(grid1, grid2));
        
        int[][] grid3 = {
            {1,0,1,0,1},
            {1,1,1,1,1},
            {0,0,0,0,0},
            {1,1,1,1,1},
            {1,0,1,0,1}
        };
        
        int[][] grid4 = {
            {0,0,0,0,0},
            {1,1,1,1,1},
            {0,1,0,1,0},
            {0,1,0,1,0},
            {1,0,0,0,1}
        };
        System.out.println(islands.count(grid3, grid4));


    }
}