//Problem: https://leetcode.com/problems/special-positions-in-a-binary-matrix/description/



import java.io.*;
import java.util.*;

class BinaryMatrix {
    public int numSpecial(int[][] mat) {
        int m=mat.length, n=mat[0].length, ans=0;
        int[] rowSum = new int[m];
        int[] colSum = new int[n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                rowSum[i]+=mat[i][j];
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                colSum[i]+=mat[j][i];
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j]==1 && rowSum[i]==1 && colSum[j]==1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        BinaryMatrix matrix = new BinaryMatrix();
        int[][] mat = {{1,0,0},{0,0,1},{1,0,0}};
        System.out.println(matrix.numSpecial(mat));
        
        int[][] mat1 = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(matrix.numSpecial(mat1));
    }
}