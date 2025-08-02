//Problem: https://leetcode.com/problems/prime-in-diagonal/description/




import java.io.*;
import java.util.*;

class PrimeDiagonal {
    public int diagonalPrime(int[][] nums) {
        int maxVal=0, n=nums.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if((i==j || i==n-j-1) && isPrime(nums[i][j])) {
                    maxVal = Math.max(maxVal, nums[i][j]);
                }
            }
        }
        return maxVal;
    }

    public boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }
        if(n==2) {
            return true;
        }
        if(n%2==0) {
            return false;
        }
        for(int i=3; i*i<=n; i+=2) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }
}


class Main {
    public static void main(String[] args) {
        PrimeDiagonal matrix = new PrimeDiagonal();
        int[][] nums = {{1,2,3},{5,6,7},{9,10,11}};
        System.out.println(matrix.diagonalPrime(nums));
        
        int[][] nums1 = {{1,2,3},{5,17,7},{9,11,10}};
        System.out.println(matrix.diagonalPrime(nums1));
    }
}