//Problem: https://leetcode.com/problems/rotting-oranges/description/

import java.util.*;
import java.io.*;

class RottenOranges {
    public int countMinutes(int[][]grid) {
        int n=grid.length, m=grid[0].length,totalMins=0,freshOranges=0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    freshOranges++;
                }
                if(grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                }
            }
        }
        if(freshOranges == 0) {
            return 0;
        }
        while(!q.isEmpty()) {
            int[] dx={-1,0,1,0};
            int[] dy={0,1,0,-1};
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] t = q.poll();
                for(int j=0; j<4; j++) {
                    int x = t[0] + dx[j];
                    int y = t[1] + dy[j];
                    if(x>=0 && x<n && y>=0 && y<m && grid[x][y]==1) {
                        grid[x][y] = 2;
                        freshOranges--;
                        q.add(new int[]{x,y});
                    }
                }
            }
            if(q.size()!=0) {
                totalMins++;
            }
        }
        return totalMins;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
            {2,1,1},
            {1,1,0},
            {0,1,2}
        };
        RottenOranges rotten = new RottenOranges();
        System.out.println(rotten.countMinutes(grid));
    }
}