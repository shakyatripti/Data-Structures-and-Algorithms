//Problem: https://leetcode.com/problems/increment-submatrices-by-one/description/





import java.io.*;
import java.util.*;

class IncrementSubmatrices {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];
        for(int i=0; i<queries.length; i++) {
            int row1 = queries[i][0];
            int col1 = queries[i][1];
            int row2 = queries[i][2];
            int col2 = queries[i][3];
            for(int j=row1; j<=row2; j++) {
                for(int k=col1; k<=col2; k++) {
                    mat[j][k]++;
                }
            }
        }
        return mat;
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
        IncrementSubmatrices mat = new IncrementSubmatrices();
        int[][] queries = {{1,1,2,2},{0,0,1,1}};
        int[][] ans = mat.rangeAddQueries(3, queries);
        mat.display(ans);
        
        System.out.println();
        
        int[][] queries1 = {{0,0,1,1}};
        int[][] ans1 = mat.rangeAddQueries(2, queries1);
        mat.display(ans1);
    }
}