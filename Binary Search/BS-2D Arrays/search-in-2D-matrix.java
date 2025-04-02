//Problem: https://leetcode.com/problems/search-a-2d-matrix/description/


import java.io.*;
import java.util.*;

class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length, m=matrix[0].length, k=0;
        int[] arr = new int[n*m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                arr[k] = matrix[i][j];
                k++;
            }
        }
        return search(arr, target);
    }
    
    public boolean search(int[] arr, int target) {
        int l=0, r=arr.length-1;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(arr[mid]==target) {
                return true;
            } else if(arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        SearchIn2DMatrix arr = new SearchIn2DMatrix();
        System.out.println(arr.searchMatrix(matrix, 3));
        System.out.println(arr.searchMatrix(matrix, 14));
        
        int[][] matrix1 = {{1}};
        System.out.println(arr.searchMatrix(matrix, 0));
    }
}