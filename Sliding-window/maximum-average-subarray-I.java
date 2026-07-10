//Problem: https://leetcode.com/problems/maximum-average-subarray-i/description/




import java.io.*;
import java.util.*;


class SubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        double avg = Integer.MIN_VALUE, sum = 0;
        int n=nums.length;
        for(int i=0; i<k; i++) {
            sum+=nums[i];
        }
        for(int i=0; i<=n-k; i++) {
            double val = (double) (sum/k);
            avg = Math.max(avg, val);
            sum-=nums[i];
            if(i+k < n) {
                sum+=nums[i+k];
            }
        }
        return avg;
    }
}


class Main {
    public static void main(String[] args) {
        SubarrayI arr = new SubarrayI();
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(arr.findMaxAverage(nums, 4));
        
        int[] nums1 = {5};
        System.out.println(arr.findMaxAverage(nums1, 1));
        
        int[] nums2 = {-1};
        System.out.println(arr.findMaxAverage(nums2, 1));
    }
}