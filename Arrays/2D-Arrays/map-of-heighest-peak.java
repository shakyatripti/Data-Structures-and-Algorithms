//Problem: https://leetcode.com/problems/map-of-highest-peak/description/

import java.util.*;
import java.io.*;


class MapOfHighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        int r = isWater.length, c = isWater[0].length;
        boolean[][] visited = new boolean[r][c];
        Queue<Cells> q = new LinkedList<>();
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(isWater[i][j] == 1) {
                    q.add(new Cells(i,j,0));
                    visited[i][j] = true;
                    isWater[i][j] = 0;
                } else {
                    visited[i][j] = false;
                }
            }
        }
        while(!q.isEmpty()) {
            int size = q.size();
            int[] dx={-1,0,1,0};
            int[] dy={0,1,0,-1};
            for(int i=0; i<size; i++) {
                Cells water = q.poll();
                for(int j=0; j<4; j++) {
                    int x = water.first + dx[j];
                    int y = water.second + dy[j];
                    int steps = water.third;
                    if(x>=0 && x<r && y>=0 && y<c && !visited[x][y]) {
                        q.add(new Cells(x,y,steps+1));
                        isWater[x][y] = steps + 1;
                        visited[x][y] = true;
                    }
                }
            }
        }
        return isWater;
    }
}

class Cells {
    int first;
    int second;
    int third;
    Cells(int f, int s, int t) {
        first = f;
        second = s;
        third = t;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] isWater = new int[][] {
            {0,0,1},{1,0,0},{0,0,0}
        };
        MapOfHighestPeak peak = new MapOfHighestPeak();
        int[][] ans = peak.highestPeak(isWater);
        for(int i=0; i<ans.length; i++) {
            for(int j=0; j<ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}