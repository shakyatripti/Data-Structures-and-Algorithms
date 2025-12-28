//Problem: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/





import java.io.*;
import java.util.*;

class SortedMatrix {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        SortedMatrix mat = new SortedMatrix();
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(mat.countNegatives(grid));
        
        int[][] grid1 = {{3,2},{1,0}};
        System.out.println(mat.countNegatives(grid1));
    }
}