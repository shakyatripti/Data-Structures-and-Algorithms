//Problem: https://leetcode.com/problems/maximum-sum-with-at-most-k-elements/description/





import java.io.*;
import java.util.*;

class MatrixWithLimits {
    public long maxSum(int[][] grid, int[] limits, int k) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        long ans = 0;
        int n=grid.length, m=grid[0].length;
        for(int i=0; i<n; i++) {
            int count = 0;
            Arrays.sort(grid[i]);
            for(int j=m-1; j>=0; j--) {
                if(count==limits[i]) {
                    break;
                } else {
                    arr.add(grid[i][j]);
                }
                count++;
            }
        }

        Collections.sort(arr);
        int q=arr.size()-1;
        while(k > 0) {
            ans+=arr.get(q);
            q--;
            k--;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        MatrixWithLimits mat = new MatrixWithLimits();
        int[][] grid = {{1,2},{3,4}};
        int[] limits = {1,2};
        System.out.println(mat.maxSum(grid, limits, 2));
        
        int[][] grid1 = {{5,3,7},{8,2,6}};
        int[] limits1 = {2,2};
        System.out.println(mat.maxSum(grid1, limits1, 3));
    }
}