//Problem: https://leetcode.com/problems/shortest-path-in-binary-matrix/


/*NOTE: Same problem has been solved using BFS */
/* Complexity is optimal using BFS rather than Dijkstra's Algorithm */

import java.util.*;
import java.io.*;

class ShortestPathInBinaryMatrix {
    public int shortestPath(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        int[][] distance = new int[n][m];
        for(int i=0; i<n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((x,y) -> x.get(0) - y.get(0));
        if(grid[0][0] == 0) {
            pq.add(new ArrayList<>(Arrays.asList(1,0,0)));
            distance[0][0] = 1;
        }
        int[] dx = {-1,-1,0,1,1,1,0,-1};
        int[] dy = {0,1,1,1,0,-1,-1,-1};
        while(!pq.isEmpty()) {
            List<Integer> curr = pq.poll();
            int dist = curr.get(0);
            int row = curr.get(1);
            int col = curr.get(2);
            for(int i=0; i<8; i++) {
                int x = row + dx[i];
                int y = col + dy[i];
                if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==0) {
                    int k = dist + 1;
                    if(distance[x][y] > k) {
                        distance[x][y] = k;
                        pq.add(new ArrayList(Arrays.asList(k,x,y)));
                    }
                }
            }
        }
        return distance[n-1][m-1]==Integer.MAX_VALUE ? -1 : distance[n-1][m-1];
    }
}

class Main {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
            {0,0,0},{1,0,0},{1,1,0}
        };
        int[][] grid2 = new int[][] {
            {1,0,1,1}, {0,0,0,0}, {1,1,1,0}
        };
        ShortestPathInBinaryMatrix matrix = new ShortestPathInBinaryMatrix();
        System.out.println(matrix.shortestPath(grid));
        System.out.println(matrix.shortestPath(grid2));
    }
}