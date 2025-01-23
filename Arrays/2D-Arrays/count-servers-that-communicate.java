//Problem: https://leetcode.com/problems/count-servers-that-communicate/description/

import java.util.*;
import java.io.*;

class CountServersThatCommunicate {
    public int countServers(int[][] grid) {
        int r=grid.length, c=grid[0].length, ans=0;
        int[] row = new int[r];
        int[] col = new int[c];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j]==1 && (row[i] > 1 || col[i] > 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
            {1,0,0,1},
            {0,1,0,1},
            {0,0,1,0}
        };
        CountServersThatCommunicate servers = new CountServersThatCommunicate();
        System.out.println(servers.countServers(grid));
    }
}