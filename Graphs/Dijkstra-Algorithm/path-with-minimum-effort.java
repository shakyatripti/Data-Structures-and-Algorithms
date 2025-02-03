//Prolem: https://leetcode.com/problems/path-with-minimum-effort/

import java.util.*;
import java.io.*;

class PathWithMinimumEffort {
    public int minimumEffort(int[][] heights) {
        int n=heights.length, m=heights[0].length;
        int[][] distance = new int[n][m];
        for(int i=0; i<n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((x,y) -> x.get(0) - y.get(0));
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        pq.add(new ArrayList<>(Arrays.asList(0,0,0)));
        while(!pq.isEmpty()) {
            List<Integer> currHeight = pq.poll();
            int dist = currHeight.get(0);
            int row = currHeight.get(1);
            int col = currHeight.get(2);
            for(int i=0; i<4; i++) {
                int x = dx[i] + row;
                int y = dy[i] + col;
                if(x>=0 && y>=0 && x<n && y<m) {
                    int k = Math.max(Math.abs(heights[x][y]-heights[row][col]), dist);
                    if(distance[x][y] > k) {
                        distance[x][y] = k;
                        pq.add(new ArrayList<>(Arrays.asList(k,x,y)));
                    }
                }
            }
        }
        return distance[n-1][m-1];
    }
}

class Main {
    public static void main(String[] args) {
        int[][] heights = new int[][] {
            {1,2,2},{3,8,2},{5,3,5}
        };
        int[][] heights2 = new int[][] {
            {1,2,3},{3,8,4},{5,3,5}
        };
        int[][] heights3 = new int[][] {
            {1,10,8,3,4,6,9,4}
        };
        PathWithMinimumEffort matrix = new PathWithMinimumEffort();
        System.out.println(matrix.minimumEffort(heights));
        System.out.println(matrix.minimumEffort(heights2));
        System.out.println(matrix.minimumEffort(heights3));
    }
}