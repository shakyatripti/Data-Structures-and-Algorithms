//Problem: https://leetcode.com/problems/maximum-prime-difference/description/




import java.io.*;
import java.util.*;

class PrimeDifference {
    public int maxDiff(int[] nums) {
        int minVal=101, maxVal=0;
        for(int i=0; i<nums.length; i++) {
            if(isPrime(nums[i])) {
                minVal = Math.min(i, minVal);
                maxVal = Math.max(i, maxVal);
            }
        }
        return Math.abs(maxVal-minVal);
    }

    public boolean isPrime(int n) {
        if(n < 2) return false;
        if(n==2) return true;
        if(n%2==0) return false;
        for(int i=3; i*i<=n ; i+=2) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        PrimeDifference arr = new PrimeDifference();
        int[] nums = {4,2,9,5,3};
        System.out.println(arr.maxDiff(nums));
        
        int[] nums1 = {4,8,2,8};
        System.out.println(arr.maxDiff(nums1));
        
        int[] nums2 = {2,2};
        System.out.println(arr.maxDiff(nums2));
    }
}