//Problem: https://leetcode.com/problems/sort-the-matrix-diagonally/description/



import java.io.*;
import java.util.*;

class SortTheMatrix {
    public int[][] diagonallySort(int[][] mat) {
        int m=mat.length, n=mat[0].length;
        HashMap<Integer, PriorityQueue<Integer>> mp = new HashMap<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                mp.putIfAbsent(j-i, new PriorityQueue<>());
                mp.get(j-i).add(mat[i][j]);
            }
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                mat[i][j] = mp.get(j-i).poll();
            }
        }
        return mat;
    }
    
    public void display(int[][] mat) {
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}

class Main {
    public static void main(String[] args) {
        SortTheMatrix matrix = new SortTheMatrix();
        int[][] mat = {
            {11,25,66,1,69,7},
            {23,55,17,45,15,52},
            {75,31,36,44,58,8},
            {22,27,33,25,68,4},
            {84,28,14,11,5,20}
        };
        int[][] ans = matrix.diagonallySort(mat);
        matrix.display(ans);
        System.out.println();
        int[][] mat1 = {
            {3,3,1,1},
            {2,2,1,2},
            {1,1,1,2}
        };
        int[][] ans1 = matrix.diagonallySort(mat1);
        matrix.display(ans1);
    }
}



