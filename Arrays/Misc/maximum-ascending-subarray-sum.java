//Problem: https://leetcode.com/problems/maximum-ascending-subarray-sum/description/

import java.util.*;
import java.io.*;

class MaximumAscendingSubArray {
    public int maxSubArraySum(int[] nums) {
        int r=1,l=0, ans=0, sum=nums[0];
        while(r<nums.length) {
            if(nums[l] < nums[r]) {
                sum+=nums[r];
            } else {
                ans = Math.max(ans, sum);
                sum = nums[r];
            }
            l++;
            r++;
        }
        ans = Math.max(ans, sum);
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {10,20,30,5,20,50,60};
        int[] nums2 = {2,10,3,49,49,50};
        int[] nums3 = {32};
        MaximumAscendingSubArray arr = new MaximumAscendingSubArray();
        System.out.println(arr.maxSubArraySum(nums));
        System.out.println(arr.maxSubArraySum(nums2));
        System.out.println(arr.maxSubArraySum(nums3));
    }
}