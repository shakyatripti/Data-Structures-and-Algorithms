//Problem: https://leetcode.com/problems/as-far-from-land-as-possible/description/


//Brute Force solution
import java.io.*;
import java.util.*;

class AsFarFromLand {
    public int maxDistance(int[][] grid) {
        int n = grid.length, m = grid[0].length, ans=Integer.MIN_VALUE;
        int[][] distance = new int[n][m];
        for(int i=0; i<n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==1) {
                    distance[i][j] = -1;
                    findNearestLand(i,j,grid,distance);
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                ans = Math.max(ans, distance[i][j]);
            }
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
        
    }
    
    public void findNearestLand(int r, int c, int[][] grid, int[][]distance) {
        int n=grid.length, m=grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            Arrays.fill(visited[i], false);
        }
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        while(!q.isEmpty()) {
            int[] t = q.poll();
            for(int i=0; i<4; i++) {
                int x = dx[i] + t[0];
                int y = dy[i] + t[1];
                if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==0 && !visited[x][y]) {
                    q.add(new int[]{x,y});
                    visited[x][y] = true;
                    int dist = Math.abs(r-x) + Math.abs(c-y);
                    if(distance[x][y] > dist) {
                        distance[x][y] = dist;
                    }
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        int[][] grid = {{1,0,0},{0,0,0},{0,0,0}};
        AsFarFromLand land = new AsFarFromLand();
        System.out.println(land.maxDistance(grid));
    }
}



//Optimal solution
import java.io.*;
import java.util.*;

class AsFarFromLand {
    public int maxDistance(int[][] grid) {
        int n = grid.length, m = grid[0].length, distance=-1;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==1) {
                    q.add(new int[]{i,j});
                }
            }
        }
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        while(!q.isEmpty()) {
            int size = q.size();
            distance++;
            for(int i=0; i<size; i++) {
                int[] currPos = q.poll();
                for(int j=0; j<4; j++) {
                    int x = currPos[0] + dx[j];
                    int y = currPos[1] + dy[j];
                    if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==0) {
                        grid[x][y]=1;
                        q.add(new int[]{x,y});
                    }
                }
            }
        }
        return distance==0 ? -1 : distance;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] grid = {{1,0,1},{0,0,0},{1,0,1}};
        AsFarFromLand land = new AsFarFromLand();
        System.out.println(land.maxDistance(grid));
    }
}