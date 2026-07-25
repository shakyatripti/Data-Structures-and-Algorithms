//Problem: https://leetcode.com/problems/reverse-vowels-of-a-string/description/




import java.io.*;
import java.util.*;


class Matrix {
    public int diagonalSum(int[][] mat) {
        int n=mat.length, sum=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i==j || i==n-j-1) {
                    sum+=mat[i][j];
                }
            }
        }    
        return sum;
    }
}


class Main {
    public static void main(String[] args) {
        Matrix grid = new Matrix();
        int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(grid.diagonalSum(mat));
        
        int[][] mat1 = {{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}};
        System.out.println(grid.diagonalSum(mat1));
    }
}