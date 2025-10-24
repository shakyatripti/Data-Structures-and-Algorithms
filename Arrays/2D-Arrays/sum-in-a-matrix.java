//Problem: https://leetcode.com/problems/sum-in-a-matrix/description/




import java.io.*;
import java.util.*;

class MatrixSum {
    public int calculateSum(int[][] nums) {
        int sum = 0, n = nums.length, m = nums[0].length;
        for(int[] rows: nums) {
            Arrays.sort(rows);
        }
        for(int i=0; i<m; i++) {
            int maxRow = 0;
            for(int j=0; j<n; j++) {
                maxRow = Math.max(maxRow, nums[j][i]);
            }
            sum+=maxRow;
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        MatrixSum matrix = new MatrixSum();
        int[][] nums = {{7,2,1},{6,4,2},{6,5,3},{3,2,1}};
        System.out.println(matrix.calculateSum(nums));
        
        int[][] nums1 = {{1}};
        System.out.println(matrix.calculateSum(nums1));
    }
}