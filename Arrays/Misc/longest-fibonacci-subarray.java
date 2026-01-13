//Problem: https://leetcode.com/problems/longest-fibonacci-subarray/description/





import java.io.*;
import java.util.*;

class FibonacciSubarray {
    public int longestSubarray(int[] nums) {
        int ans = 0, len = 0, prev1 = nums[0], prev2 = nums[1];
        for(int i=2; i<nums.length; i++) {
            if(prev1 + prev2 == nums[i]) {
                len++;
            } else {
                ans = Math.max(len+2, ans);
                len = 0;
            }
            prev1 = prev2;
            prev2 = nums[i];
        }
        ans = Math.max(len+2, ans);
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        FibonacciSubarray arr = new FibonacciSubarray();
        int[] nums = {1,1,1,1,2,3,5,1};
        System.out.println(arr.longestSubarray(nums));
        
        int[] nums1 = {5,2,7,9,16};
        System.out.println(arr.longestSubarray(nums1));
        
        int[] nums2 = {1000000000,1000000000,1000000000};
        System.out.println(arr.longestSubarray(nums2));
        
        int[] nums3 = {3,1,4,5,3,1,4,3,1,4};
        System.out.println(arr.longestSubarray(nums3));
    }
}