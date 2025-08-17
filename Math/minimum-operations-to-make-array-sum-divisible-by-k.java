//Problem: https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/description/



import java.io.*;
import java.util.*;

class DivisibleByK {
    public int minOperations(int[] nums, int k) {
        int prefixSum = 0;
        for(int i=0; i<nums.length; i++) {
            prefixSum+=nums[i];
        }
        return prefixSum%k;
    }
}

class Main {
    public static void main(String[] args) {
        DivisibleByK arr = new DivisibleByK();
        int[] nums = {3,9,7};
        System.out.println(arr.minOperations(nums, 5));
        
        int[] nums1 = {4,1,3};
        System.out.println(arr.minOperations(nums1, 4));
        
        int[] nums2 = {3,2};
        System.out.println(arr.minOperations(nums2, 6));
    }
}