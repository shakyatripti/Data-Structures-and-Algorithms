//Problem: https://leetcode.com/problems/minimum-size-subarray-sum/description/


import java.io.*;
import java.util.*;

class MinSizeSubarraySum {
    public int minimumLen(int[] nums, int target) {
        int maxSum = Integer.MAX_VALUE, l=0, sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            while(sum>=target) {
                maxSum = Math.min(maxSum, i-l+1);
                sum-=nums[l];
                l++;
            }
        }
        return maxSum==Integer.MAX_VALUE ? 0 : maxSum;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        MinSizeSubarraySum subarray = new MinSizeSubarraySum();
        System.out.println(subarray.minimumLen(nums, 7));
        int[] nums2 = {1,2,3,4,5};
        System.out.println(subarray.minimumLen(nums2, 11));
        int[] nums3 = {1,1,1,1,1,1};
        System.out.println(subarray.minimumLen(nums3, 10));
    }
}