//Problem: https://leetcode.com/problems/find-the-degree-of-each-vertex/description/




import java.io.*;
import java.util.*;

class DegreeOfVertex {
    public int[] findDegrees(int[][] matrix) {
        int n=matrix.length;
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=0; j<n; j++) {
                if(matrix[i][j]==1) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
    
    public void display(int[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

class Main {
      public static void main(String[] args) {
        DegreeOfVertex vertex = new DegreeOfVertex();
        int[][] matrix = {{0,1,1},{1,0,1},{1,1,0}};
        int[] ans = vertex.findDegrees(matrix);
        vertex.display(ans);
        
        int[][] matrix1 = {{0,1,0},{1,0,0},{0,0,0}};
        int[] ans1 = vertex.findDegrees(matrix1);
        vertex.display(ans1);
        
        int[][] matrix2 = {{0}};
        int[] ans2 = vertex.findDegrees(matrix2);
        vertex.display(ans2);
    }
}