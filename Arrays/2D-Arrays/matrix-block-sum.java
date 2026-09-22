//Problem: https://leetcode.com/problems/matrix-block-sum/description/




import java.io.*;
import java.util.*;


class MatrixBlock {
    public int[][] findSum(int[][] mat, int k) {
        int m=mat.length, n=mat[0].length;
        int[][] ans = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int total = 0;
                for(int p=i-k; p<=i+k; p++) {
                    for(int q=j-k; q<=j+k; q++) {
                        if(p>=0 && p<m && q>=0 && q<n) {
                            total+=mat[p][q];
                        }
                    }
                }
                ans[i][j] = total;
            }
        }
        return ans;
    }
    
    public void display(int[][] ans) {
        for(int i=0; i<ans.length; i++) {
            for(int j=0; j<ans.length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        MatrixBlock matrix = new MatrixBlock();
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] ans = matrix.findSum(mat, 1);
        matrix.display(ans);
        
        int[][] mat1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] ans1 = matrix.findSum(mat1, 2);
        matrix.display(ans1);
        
    }
}