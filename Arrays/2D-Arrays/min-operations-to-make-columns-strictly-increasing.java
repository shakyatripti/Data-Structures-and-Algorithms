//Problem: https://leetcode.com/problems/minimum-operations-to-make-columns-strictly-increasing/description/




import java.io.*;
import java.util.*;

class MakeColumnsIncreasing {
    public int minimumOperations(int[][] grid) {
        int ans=0;
        for(int i=0; i<grid[0].length; i++) {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            for(int j=0; j<grid.length; j++) {
                arr.add(grid[j][i]);
            }
            ans+=makeArrayIncreasing(arr);
        }
        return ans;
    }

    public int makeArrayIncreasing(ArrayList<Integer> arr) {
        int val = arr.get(0), sum = 0;
        for(int i=1; i<arr.size(); i++) {
            val++;
            if(arr.get(i) < val) {
                sum+=val - arr.get(i);
            } else {
                val = arr.get(i);
            }
        }
        return sum;
    }
}


class Main {
    public static void main(String[] args) {
        MakeColumnsIncreasing matrix = new MakeColumnsIncreasing();
        int[][] grid = {{3,2},{1,3},{3,4},{0,1}};
        System.out.println(matrix.minimumOperations(grid));
        
        int[][] grid1 = {{3,2,1},{2,1,0},{1,2,3}};
        System.out.println(matrix.minimumOperations(grid1));
        
        int[][] grid2 = {{0},{50},{11}};
        System.out.println(matrix.minimumOperations(grid2));
        
        int[][] grid3 = {{10,3,4},{8,9,11},{2,1,3}};
        System.out.println(matrix.minimumOperations(grid3));
    }
}