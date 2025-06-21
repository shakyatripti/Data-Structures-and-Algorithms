//Problem: https://leetcode.com/problems/find-champion-i/description




import java.io.*;
import java.util.*;

class FindChampion {
    public int findStrongestTeam(int[][] grid) {
        int n=grid.length, ans=0, res=0;
        int[] strength = new int[n];
        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=0; j<n; j++) {
                if(grid[i][j]==1) {
                    count++;
                }
            }
            strength[i] = count;
        }
        for(int i=0; i<n; i++) {
            if(ans < strength[i]) {
                ans = strength[i];
                res = i;
            }
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        FindChampion champion = new FindChampion();
        int[][] grid = {{0,1},{0,0}};
        System.out.println(champion.findStrongestTeam(grid));
        
        int[][] grid1 = {{0,0,1},{1,0,1},{0,0,0}};
        System.out.println(champion.findStrongestTeam(grid1));
    }
}