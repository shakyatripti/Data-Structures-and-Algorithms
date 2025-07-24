//Problem: https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/description/




import java.io.*;
import java.util.*;

class CountIslands {
    public int isDivisible(int[][] grid, int k) {
        int m=grid.length, n=grid[0].length, ans=0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]!=0 && !visited[i][j]) {
                    int sum = totalSum(grid, i, j, visited, m, n);
                    if(sum%k==0) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public int totalSum(int[][] grid, int row, int col, boolean[][] visited, int m, int n) {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        visited[row][col] = true;
        int sum = 0;
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int r = pos[0];
            int c = pos[1];
            sum+=grid[r][c];
            for(int i=0; i<4; i++) {
                int x = dx[i] + r;
                int y = dy[i] + c;
                if(x>=0 &&  x<m && y>=0 && y<n && grid[x][y]!=0 && !visited[x][y]) {
                    q.add(new int[]{x,y});
                    visited[x][y] = true;
                }
            }
        }
        return sum;
    }
}


class Main {
    public static void main(String[] args) {
        CountIslands islands = new CountIslands();
        int[][] grid = {{0,2,1,0,0},{0,5,0,0,5},{0,0,1,0,0},{0,1,4,7,0},{0,2,0,0,8}};
        System.out.println(islands.isDivisible(grid, 5));
        
        int[][] grid1 = {{3,0,3,0},{0,3,0,3},{3,0,3,0}};
        System.out.println(islands.isDivisible(grid1, 3));
    }
}