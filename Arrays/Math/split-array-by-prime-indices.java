//Problem: https://leetcode.com/problems/split-array-by-prime-indices/description/



import java.io.*;
import java.util.*;

class SplitArray {
    public long sumPrimeIndices(int[] nums) {
        long sumA=0, sumB=0;
        for(int i=0; i<nums.length; i++) {
            if(isPrime(i)) {
                sumA+=nums[i];
            } else {
                sumB+=nums[i];
            }
        }
        return Math.abs(sumA-sumB);
    }
    
    public boolean isPrime(int n) {
        if(n<2) {
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
        SplitArray arr = new SplitArray();
        int[] nums = {2,3,4};
        System.out.println(arr.sumPrimeIndices(nums));
        
        int[] nums1 = {-1,5,7,0};
        System.out.println(arr.sumPrimeIndices(nums1));
    }
}