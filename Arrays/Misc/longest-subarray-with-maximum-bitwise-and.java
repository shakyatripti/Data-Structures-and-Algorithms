//Problem: https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/description/



/*Problem Statement: Firstly, we need to find the maximum bitwise AND in subarray as K. Then we need to find the length of the longest subarray with
    value equals to K. Example: {1,3,2,3,3} is the array and its unique subarray as {1,1}, {1,2}, {1,3}, {2,2}, {2,3}, {3,3} the maximum bitwise AND among all these
    pairs is 3. Now we need to find the length of the longest subarray with value equals to 3, which is 2.
*/


import java.io.*;
import java.util.*;

class LongestSubArray {
    public int maxBitwiseAnd(int[] nums) {
        int maxVal = 0, len = 0, count = 0;
        for(int i=0; i<nums.length; i++) {
            maxVal = Math.max(maxVal, nums[i]);
        }
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==maxVal) {
               count++;
            } else {
               len = Math.max(len, count);
               count = 0;
            }
        }
        len = Math.max(len, count);
        return len;
    }
}

class Main {
    public static void main(String[] args) {
        LongestSubArray arr = new LongestSubArray();
        int[] nums = {1,2,3,3,2,2};
        System.out.println(arr.maxBitwiseAnd(nums));
        
        int[] nums1 = {1,2,3,4};
        System.out.println(arr.maxBitwiseAnd(nums1));
        
        int[] nums2 = {5,5,0,1,2,4,5,5,5,0,3};
        System.out.println(arr.maxBitwiseAnd(nums2));
    }
}