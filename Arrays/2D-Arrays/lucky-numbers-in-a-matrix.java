//Problem: https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/



import java.io.*;
import java.util.*;

class NumbersInMatrix {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(isLucky(matrix, i, j, m, n)) {
                    ans.add(matrix[i][j]);
                }
            }
        }
        return ans;
    }

    public boolean isLucky(int[][] matrix, int r, int c, int m, int n) {
        int row = Integer.MAX_VALUE;
        int col = 0;
        for(int i=0; i<n; i++) {
            row = Math.min(row, matrix[r][i]);
        }

        for(int j=0; j<m; j++) {
            col = Math.max(col, matrix[j][c]);
        }

        if(row==matrix[r][c] && col==matrix[r][c]) {
            return true;
        }
        return false;
    }
    
    public void display(List<Integer> ans) {
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        NumbersInMatrix mat = new NumbersInMatrix();
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        List<Integer> ans = mat.luckyNumbers(matrix);
        mat.display(ans);
        
        int[][] matrix1 = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
        List<Integer> ans1 = mat.luckyNumbers(matrix1);
        mat.display(ans1);
        
        int[][] matrix2 = {{7,8},{1,2}};
        List<Integer> ans2 = mat.luckyNumbers(matrix2);
        mat.display(ans2);
    }
}