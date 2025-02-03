//Problem: https://leetcode.com/problems/shortest-path-in-binary-matrix/description/


/* NOTE: Same problem has been solved using Dijkstra's algorithm.*/
/* Complexity is optimal using BFS rather than Dijkstra's Algorithm */

import java.util.*;
import java.io.*;

class ShortestPathInBinaryMatrix {
    public int shortestPath(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Tuple> q = new LinkedList<>();
        if(grid[0][0]==0) {
            if(n==1 && m==1) {
                return 1;
            } else {
                q.add(new Tuple(1,0,0));
                visited[0][0] = true;
            }
        }
        int[] dx = {-1,-1,0,1,1,1,0,-1};
        int[] dy = {0,1,1,1,0,-1,-1,-1};
        while(!q.isEmpty()) {
            Tuple curr = q.poll();
            int state = curr.state;
            for(int i=0; i<8; i++) {
                int x = dx[i] + curr.row;
                int y = dy[i] + curr.col;
                if(x>=0 && y>=0 && x<n && y<m && !visited[x][y] && grid[x][y]==0) {
                    q.add(new Tuple(state+1,x,y));
                    visited[x][y] = true;
                }
                if(x==n-1 && y==m-1 && grid[x][y]==0) {
                    return state + 1;
                }
            }
        }
        return -1;
    }
}

class Tuple {
    int state;
    int row;
    int col;
    Tuple(int s, int r, int c) {
        state = s;
        row = r;
        col = c;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
            {0,0,0},{1,1,0},{1,1,0}
        };
        int[][] grid2 = new int[][] {
            {1,0,1,1}, {0,0,0,0}, {1,1,1,0}
        };
        int[][] grid3 = new int[][]{{0}};
        ShortestPathInBinaryMatrix matrix = new ShortestPathInBinaryMatrix();
        System.out.println(matrix.shortestPath(grid));
        System.out.println(matrix.shortestPath(grid2));
        System.out.println(matrix.shortestPath(grid3));
    }
}

