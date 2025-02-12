//Problem: https://leetcode.com/problems/find-all-groups-of-farmland/description/


import java.util.*;
import java.io.*;

class GroupsOfFarmLand {
    public int[][] farmLands(int[][] land) {
        int n=land.length, m=land[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            Arrays.fill(visited[i], false);
        }
        ArrayList<int[]> farms = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(land[i][j]==1 && !visited[i][j]) {
                    visited[i][j] = true;
                    farms.add(findLandGroups(i,j,land,visited));
                }
            }
        }
        int[][] groups = new int[farms.size()][4];
        for(int i=0; i<farms.size(); i++) {
            groups[i] = farms.get(i);
        }
        return groups;
    }
    
    public int[] findLandGroups(int r1, int r2, int[][] land, boolean[][] visited) {
        int n = land.length, m = land[0].length;
        int[] result = new int[4];
        result[0]=r1;
        result[1]=r2;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r1,r2});
        while(!q.isEmpty()) {
            int[] farm = q.poll();
            result[2] = farm[0];
            result[3] = farm[1];
            for(int i=0; i<4; i++) {
                int x = dx[i] + farm[0];
                int y = dy[i] + farm[1];
                if(x>=0 && y>=0 && x<n && y<m && land[x][y]==1 && !visited[x][y]) {
                    q.add(new int[]{x,y});
                    visited[x][y] = true;
                }
            }
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] land = {{1,0,0},{0,1,1},{0,1,1}};
        GroupsOfFarmLand groups = new GroupsOfFarmLand();
        int[][] result = groups.farmLands(land);
        for(int i=0; i<result.length; i++) {
            for(int j=0; j<result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}