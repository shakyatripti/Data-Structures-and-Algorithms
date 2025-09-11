//Problem: https://leetcode.com/problems/delete-greatest-value-in-each-row/description/




import java.io.*;
import java.util.*;

class DeleteInEachRow {
    public int deleteGreatestValue(int[][] grid) {
        int m=grid.length, n=grid[0].length, ans=0;
        for(int[] row: grid) {
            Arrays.sort(row);
        }

        for(int i=0; i<n; i++) {
            int maxVal=0;
            for(int j=0; j<m; j++) {
                maxVal = Math.max(grid[j][i], maxVal);
            }
            ans+=maxVal;
        }
        return ans;
    }
}


class Main {
    public static void main(String[] args) {
        DeleteInEachRow matrix = new DeleteInEachRow();
        int[][] grid = {{1,2,4},{3,3,1}};
        System.out.println(matrix.deleteGreatestValue(grid));
        
        int[][] grid1 = {{10}};
        System.out.println(matrix.deleteGreatestValue(grid1));
    }
}