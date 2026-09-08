//Problem: https://leetcode.com/problems/maximum-score-of-a-split/description/




import java.io.*;
import java.util.*;

class SplitArray{
    public long maximumScore(int[] nums) {
        int n=nums.length;
        long ans=Long.MIN_VALUE, sum=0, val=Long.MAX_VALUE;
        long[] prefixSum = new long[n];
        long[] suffixMin = new long[n];

        for(int i=0; i<n; i++) {
            sum+=nums[i];
            prefixSum[i] = sum;
        }

        for(int i=n-1; i>0; i--) {
            val = Math.min(val, nums[i]);
            suffixMin[i-1] = val;
        }

        for(int i=0; i<n-1; i++) {
            ans = Math.max(ans, (prefixSum[i] - suffixMin[i]));
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        SplitArray arr = new SplitArray();
        int[] nums = {10,-1,3,-4,-5};
        System.out.println(arr.maximumScore(nums));
        
        int[] nums1 = {-7,-5,3};
        System.out.println(arr.maximumScore(nums1));
        
        int[] nums2 = {1,1};
        System.out.println(arr.maximumScore(nums2));
        
    }
}