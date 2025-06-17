//Problem: https://leetcode.com/problems/modify-the-matrix/description/




import java.io.*;
import java.util.*;

class ModifyMatrix {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        int[] col = new int[n];
        for(int i=0; i<n; i++) {
            int maxVal = 0;
            for(int j=0; j<m; j++) {
               maxVal=Math.max(matrix[j][i], maxVal);
            }
            col[i] = maxVal;
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j]==-1) {
                    matrix[i][j] = col[j];
                }
            }
        }
        return matrix;
    }
    
    public static void display(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


class Main {
    public static void main(String[] args) {
        ModifyMatrix mat = new ModifyMatrix();
        int[][] matrix = {{1,2,-1},{4,-1,6},{7,8,9}};
        int[][] ans = mat.modifiedMatrix(matrix);
        mat.display(ans);
        
        int[][] matrix1 = {{3,-1},{5,2}};
        int[][] ans1 = mat.modifiedMatrix(matrix1);
        mat.display(ans1);
    }
}