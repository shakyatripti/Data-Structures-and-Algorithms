//Problem: https://leetcode.com/problems/row-with-maximum-ones/description/





import java.io.*;
import java.util.*;

class RowWithMaxOnes {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int rows=0, index=mat.length, ans=0;
        for(int i=0; i<mat.length; i++) {
            rows=0;
            for(int j=0; j<mat[i].length; j++) {
                if(mat[i][j]==1) {
                   rows+=mat[i][j];
                }
            }
            if(ans < rows) {
                ans = rows;
                index = i;
            }
            if(ans==rows) {
                index = Math.min(i, index);
            }
        }
        return new int[]{index, ans};
    }
}


class Main {
    public static void main(String[] args) {
        RowWithMaxOnes matrix = new RowWithMaxOnes();
        int[][] mat = {{0,0,0}, {0,1,1}};
        int[] ans = matrix.rowAndMaximumOnes(mat);
        System.out.println(ans[0] + " " + ans[1]);
        
        int[][] mat1 = {{0,0}, {0,1}, {1,0}};
        int[] ans1 = matrix.rowAndMaximumOnes(mat1);
        System.out.println(ans1[0] + " " + ans1[1]);
        
        int[][] mat2 = {{0,0,0,1}, {1,1,0,1}, {1,1,1,1}};
        int[] ans2 = matrix.rowAndMaximumOnes(mat2);
        System.out.println(ans2[0] + " " + ans2[1]);
    }
}