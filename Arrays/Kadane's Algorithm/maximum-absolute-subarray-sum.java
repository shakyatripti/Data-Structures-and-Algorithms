//Problem: https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/description/


import java.io.*;
import java.util.*;

class MaxAbsSubarraySum {
    public int maximumAbsoluteSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE, sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            if(maxSum < sum) {
                maxSum = Math.max(maxSum, sum);
            }
            if(sum < 0) {
                sum = 0;
            }
        }
        
        sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            if(minSum > sum) {
                minSum = Math.min(minSum, sum);
            }
            if(sum > 0) {
                sum = 0;
            }
        }
        minSum = Math.abs(minSum);
        return Math.max(minSum, maxSum);
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {2,-5,1,-4,3,-2};
        MaxAbsSubarraySum subarray = new MaxAbsSubarraySum();
        System.out.println(subarray.maximumAbsoluteSum(nums));
        int[] nums2 = {4};
        System.out.println(subarray.maximumAbsoluteSum(nums2));
        int[] nums3 = {-11};
        System.out.println(subarray.maximumAbsoluteSum(nums3));
    }
}