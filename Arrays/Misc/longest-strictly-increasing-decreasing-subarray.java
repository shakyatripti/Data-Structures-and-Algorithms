//Problem: https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/description/

import java.util.*;
import java.io.*;

class LongestMonotonicSubArray {
    public int longestSubArray(int[] nums) {
        int decrease=1, increase=1, ans=1, l=0, r=1;
        while(r<nums.length) {
            if(nums[l] < nums[r]) {
                increase++;
                decrease = 1;
            } else if(nums[l] > nums[r]) {
                increase = 1;
                decrease++;
            } else {
                increase = 1;
                decrease = 1;
            }
            l++;
            r++;
            ans = Math.max(ans, Math.max(increase, decrease));
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {1,4,3,3,2};
        int[] nums2 = {2,2,2,2};
        int[] nums3 = {3,2,4,5,7,3};
        LongestMonotonicSubArray arr = new LongestMonotonicSubArray();
        System.out.println(arr.longestSubArray(nums));
        System.out.println(arr.longestSubArray(nums2));
        System.out.println(arr.longestSubArray(nums3));
    }
}