//Problem: https://leetcode.com/problems/minimum-absolute-difference-in-sliding-submatrix/description/





import java.io.*;
import java.util.*;

class SlidingSubmatrix {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n=grid[0].length;
        int[][] ans = new int[m-k+1][n-k+1];
        for(int i=0; i<=m-k; i++) {
            for(int j=0; j<=n-k; j++) {
                ArrayList<Integer> arr = new ArrayList<>();
                int val = Integer.MAX_VALUE;
                for(int p=i; p<=i+k-1; p++) {
                    for(int q=j; q<=j+k-1; q++) {
                        if(!arr.contains(grid[p][q])) {
                            arr.add(grid[p][q]);
                        }
                    }
                    
                    Collections.sort(arr);
                    for(int c=1; c<arr.size(); c++) {
                        val = Math.min(val, (arr.get(c) - arr.get(c-1)));
                    }

                    if(val==Integer.MAX_VALUE) {
                        ans[i][j] = 0;
                    } else {
                        ans[i][j] = val;
                    }
                }
            }
        }
        return ans;
    }
    
    public void display(int[][] ans) {
        for(int i=0; i<ans.length; i++) {
            for(int j=0; j<ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Main {
    public static void main(String[] args) {
        SlidingSubmatrix matrix = new SlidingSubmatrix();
        int[][] grid = {{1,8},{3,-2}};
        int[][] ans = matrix.minAbsDiff(grid, 2);
        matrix.display(ans);
        
        int[][] grid1 = {{3,-1}};
        int[][] ans1 = matrix.minAbsDiff(grid1, 1);
        matrix.display(ans1);
        
        int[][] grid2 = {{1,-2,3},{2,3,5}};
        int[][] ans2 = matrix.minAbsDiff(grid2, 2);
        matrix.display(ans2);
    }
}