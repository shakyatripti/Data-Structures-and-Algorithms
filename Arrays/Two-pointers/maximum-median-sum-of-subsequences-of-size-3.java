//Problem: https://leetcode.com/problems/maximum-median-sum-of-subsequences-of-size-3/description/




import java.io.*;
import java.util.*;

class MedianSubsequence {
    public long maxSum(int[] nums) {
        long ans = 0;
        int l=0, r=nums.length-2;
        Arrays.sort(nums);
        while(l < r) {
            ans+=nums[r];
            r-=2;
            l++;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        MedianSubsequence seq = new MedianSubsequence();
        int[] nums = {2,1,3,2,1,3};
        System.out.println(seq.maxSum(nums));
        
        int[] nums1 = {1,1,10,10,10,10};
        System.out.println(seq.maxSum(nums1));
        
        int[] nums2 = {2,4,5,5,4,8,7,1,9};
        System.out.println(seq.maxSum(nums2));
        
        int[] nums3 = {2,1,3};
        System.out.println(seq.maxSum(nums3));
        
    }
}


