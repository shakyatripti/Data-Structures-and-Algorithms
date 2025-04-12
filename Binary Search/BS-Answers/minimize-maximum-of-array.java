//Problem: https://leetcode.com/problems/minimize-maximum-of-array/description/



import java.io.*;
import java.util.*;

class MinimizeMaximum {
    public int minimizeArrayValue(int[] nums) {
        int maxValue = -1;
        for(int i=0; i<nums.length; i++) {
            maxValue = Math.max(nums[i], maxValue);
        }
        long l=1, r=maxValue, result=0;
        while(l<=r) {
            long mid = l + (r-l)/2;
            if(isPossible(nums, mid)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return (int) result;
    }
    
    public boolean isPossible(int[] nums, long mid) {
        long[] nums2 = new long[nums.length];
        for(int i=0; i<nums.length; i++) {
            nums2[i] = (long) nums[i];
        }
        
        for(int i=0; i<nums2.length-1; i++) {
            if(nums2[i] > mid) {
                return false;
            }
            long buffer = mid - nums2[i];
            nums2[i+1] = nums2[i+1] - buffer;
        }
        return nums2[nums2.length-1]<=mid;
    }
}

class Main {
    public static void main(String[] args) {
        MinimizeMaximum arr = new MinimizeMaximum();
        int[] nums = {3,7,1,6};
        System.out.println(arr.minimizeArrayValue(nums));
        
        int[] nums2 = {13,13,20,0,8,9,9};
        System.out.println(arr.minimizeArrayValue(nums2));
        
        int[] nums3 = {10,1};
        System.out.println(arr.minimizeArrayValue(nums3));
    }
}