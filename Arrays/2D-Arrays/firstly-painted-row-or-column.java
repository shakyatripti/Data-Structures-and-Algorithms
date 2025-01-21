//Problem: https://leetcode.com/problems/first-completely-painted-row-or-column/

import java.util.*;
import java.io.*;

class Painted {
    public int firstPaintedIndex(int[][]grid, int[] arr) {
        HashMap<Integer, int[]> posMatrix = new HashMap<Integer, int[]>();
        int r=grid.length, c=grid[0].length, ans=0;
        int[] rowPainted=new int[c];
        int[] colPainted=new int[r];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                int[] position = new int[2];
                position[0]=i;
                position[1]=j;
                posMatrix.put(grid[i][j],position);
            }
        }
        for(int i=0; i<arr.length; i++) {
            int[] pos = posMatrix.get(arr[i]);
            rowPainted[pos[0]]++;
            colPainted[pos[1]]++;
            if(rowPainted[pos[0]] == c || colPainted[pos[1]] == r) {
                return i;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
            {3,2,5},
            {1,4,6},
            {8,7,9}
        };
        int [] arr = new int[]{2,8,7,4,1,3,5,6,9};
        Painted p = new Painted();
        System.out.println(p.firstPaintedIndex(grid, arr));
    }
}