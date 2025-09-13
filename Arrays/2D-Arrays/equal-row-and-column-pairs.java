//Problem: https://leetcode.com/problems/find-the-width-of-columns-of-a-grid/description/





import java.io.*;
import java.util.*;

class EqualRowAndColumns {
    public int equalPairs(int[][] grid) {
        int n=grid.length, pairs=0;
        HashMap<ArrayList<Integer>, Integer> arr = new HashMap<ArrayList<Integer>,Integer>();
        for(int i=0; i<n; i++) {
            ArrayList<Integer> arr1 = new ArrayList<Integer>();
            for(int j=0; j<n; j++) {
                arr1.add(grid[i][j]);
            }
            arr.put(arr1, arr.getOrDefault(arr1, 0) + 1);
        }

        for(int i=0; i<n; i++) {
            ArrayList<Integer> arr1 = new ArrayList<Integer>();
            for(int j=0; j<n; j++) {
                arr1.add(grid[j][i]);
            }
            if(arr.containsKey(arr1)) {
                pairs+=arr.get(arr1);
            }
        }
        return pairs;
    }
}

class Main {
    public static void main(String[] args) {
        EqualRowAndColumns matrix = new EqualRowAndColumns();
        int[][] grid = {{3,2,1},{1,7,6},{2,7,7}};
        System.out.println(matrix.equalPairs(grid));
        
        int[][] grid1 = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        System.out.println(matrix.equalPairs(grid1));
        
    }
}