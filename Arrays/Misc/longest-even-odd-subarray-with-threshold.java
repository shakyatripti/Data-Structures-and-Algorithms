//Problem: https://leetcode.com/problems/longest-even-odd-subarray-with-threshold/description/





import java.io.*;
import java.util.*;



class EvenOddSubarray {
    public int longestSubarray(int[] nums, int threshold) {
        int n=nums.length, len=0;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(isValid(nums, i, j, threshold)) {
                    len = Math.max(len, j-i+1);
                }
            }
        }
        return len;
    }

    public boolean isValid(int[] nums, int l, int r, int threshold) {
        if(nums[l]%2!=0) {
            return false;
        }
        for(int i = l; i <= r; i++) {
            if(nums[i] > threshold) {
                return false;
            }
            if(i < r && nums[i] % 2 == nums[i+1] % 2) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        EvenOddSubarray arr = new EvenOddSubarray();
        int[] nums = {3,2,5,4};
        System.out.println(arr.longestSubarray(nums, 5));
        
        int[] nums1 = {1,2};
        System.out.println(arr.longestSubarray(nums1, 2));
        
        int[] nums2 = {2,3,4,5};
        System.out.println(arr.longestSubarray(nums2, 4));
        
        int[] nums3 = {2,2};
        System.out.println(arr.longestSubarray(nums3, 18));
    }
}