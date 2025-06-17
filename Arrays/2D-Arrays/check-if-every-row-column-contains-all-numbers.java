//Problem: https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/description/




import java.io.*;
import java.util.*;

class ContainsNumInRowCol {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        int[] row = new int[n];
        int[] col = new int[n];

        for(int i=0; i<n; i++) {
            Arrays.fill(row, -1);
            Arrays.fill(col, -1);
            for(int j=0; j<n; j++) {
                int val = matrix[i][j]-1;
                int val1 = matrix[j][i]-1;
                if(row[val]!=-1 || col[val1]!=-1) {
                    return false;
                } else {
                    row[val] = 0;
                    col[val1] = 0;
                }
            }
        }
        return true;
    }
}


class Main {
    public static void main(String[] args) {
        ContainsNumInRowCol nums = new ContainsNumInRowCol();
        int[][] matrix = {{1,2,3},{3,1,2},{2,3,1}};
        System.out.println(nums.checkValid(matrix));
        
        int[][] matrix1 = {{1,1,1},{1,2,3},{1,2,3}};
        System.out.println(nums.checkValid(matrix1));
    }
}