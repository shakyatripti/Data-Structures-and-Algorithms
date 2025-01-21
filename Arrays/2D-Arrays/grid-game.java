//Problem: https://leetcode.com/problems/grid-game/?envType=daily-question&envId=2025-01-21

import java.util.*;
import java.io.*;

class GridGameSolution {
    public long gridGame(int[][] grid) {
        long rowsum1=0, rowsum2=0, ans = Long.MAX_VALUE;
        for(int i=0; i<grid[0].length; i++) {
            rowsum1+=grid[0][i];
        }
        for(int i=0; i<grid[0].length; i++) {
            rowsum1-=grid[0][i];
            ans = Math.min(ans, Math.max(rowsum1,rowsum2));
            rowsum2+=grid[1][i];
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
            {2,5,4},
            {1,5,1}
        };
        GridGameSolution game = new GridGameSolution();
        System.out.println(game.gridGame(grid));
    }
}