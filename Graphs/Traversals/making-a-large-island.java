//Problem: https://leetcode.com/problems/making-a-large-island/description/

import java.util.*;
import java.io.*;

class LargestIsland {
    public int areaOfIsland(int[][] grid) {
        int n = grid.length, area=0, maxArea=0,id=2;
        boolean[][] visited = new boolean[n][n];
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++) {
            Arrays.fill(visited[i], false);
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]==1 && !visited[i][j]) {
                    int[] sum = {1};
                    findBfs(i,j,grid,sum,id,visited,mp);
                    maxArea = Math.max(sum[0], maxArea);
                    id++;
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]==0) {
                    HashSet<Integer> islandAreas = new HashSet<Integer>();
                    int[] dx = {-1,0,1,0};
                    int[] dy = {0,1,0,-1};
                    area = 1;
                    for(int k=0; k<4; k++) {
                        int x = dx[k] + i;
                        int y = dy[k] + j;
                        if(x>=0 && y>=0 && x<n && y<n && grid[x][y]>1) {
                            islandAreas.add(grid[x][y]);
                        }
                    }
                    for(int elements: islandAreas) {
                        area+=mp.get(elements);
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
        
    }
    
    public void findBfs(int pos1, int pos2,int[][] grid, int[] sum, int id, boolean[][] visited, HashMap<Integer,Integer> mp) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{pos1,pos2});
        visited[pos1][pos2] = true;
        grid[pos1][pos2] = id;
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        while(!q.isEmpty()) {
            int[] t = q.poll();
            for(int i=0; i<4; i++) {
                int x = t[0] + dx[i];
                int y = t[1] + dy[i];
                if(x>=0 && y>=0 && x<n && y<n && grid[x][y]==1 && !visited[x][y]) {
                    q.add(new int[]{x,y});
                    sum[0]++;
                    grid[x][y] = id;
                    visited[x][y] = true;
                }
            }
        }
        mp.put(id, sum[0]);
    }
}

class Main {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
            {1,0,1},{0,0,0},{1,0,1}
        };
        int[][] grid2 = new int[][] {
            {1,1},{1,1}
        };
        int[][] grid3 = new int[][] {
            {0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}
        };
        LargestIsland island = new LargestIsland();
        System.out.println(island.areaOfIsland(grid));
        System.out.println(island.areaOfIsland(grid2));
        System.out.println(island.areaOfIsland(grid3));
    }
}