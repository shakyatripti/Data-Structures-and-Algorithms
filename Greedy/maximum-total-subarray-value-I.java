//Problem: https://leetcode.com/problems/maximum-total-subarray-value-i/description/




import java.io.*;
import java.util.*;

class SubarrayValueI {
    public long maxTotalValue(int[] nums, int k) {
        long ans = 0, minVal = Long.MAX_VALUE, maxVal = Long.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            minVal = Math.min(nums[i], minVal);
            maxVal = Math.max(nums[i], maxVal);
        }
        ans = (maxVal - minVal) * k;
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        SubarrayValueI arr = new SubarrayValueI();
        int[] nums = {1,3,2};
        System.out.println(arr.maxTotalValue(nums, 2));
        
        int[] nums1 = {4,2,5,1};
        System.out.println(arr.maxTotalValue(nums1, 3));
    }
}