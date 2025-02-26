//Problem: https://leetcode.com/problems/maximum-subarray/


import java.io.*;
import java.util.*;

class MaxSubarraySum {
    public int maximumSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            if(maxSum < sum) {
                maxSum = Math.max(maxSum, sum);
            }
            if(sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubarraySum subarray = new MaxSubarraySum();
        System.out.println(subarray.maximumSum(nums));
        int[] nums2 = {-1,-4,-5};
        System.out.println(subarray.maximumSum(nums2));
    }
}