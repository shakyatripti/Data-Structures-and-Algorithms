//Problem: https://leetcode.com/problems/find-missing-and-repeated-values/description/


//Brute Force solution
import java.io.*;
import java.util.*;

class MissingRepeatedValues {
    public int[] findMissingRepeated(int[][] grid) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                freq.put(grid[i][j], freq.getOrDefault(grid[i][j], 0) + 1);
            }
        }
        int n = grid.length * grid.length;
        for(int i=1; i<=n; i++) {
            if(!freq.containsKey(i)) {
                ans[1] = i;
            } else if(freq.get(i) > 1) {
                ans[0] = i;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] grid = {{1,3},{2,2}};
        MissingRepeatedValues arr = new MissingRepeatedValues();
        int[] ans = arr.findMissingRepeated(grid);
        for(int i: ans) {
            System.out.print(i + " ");
        }
    }
}