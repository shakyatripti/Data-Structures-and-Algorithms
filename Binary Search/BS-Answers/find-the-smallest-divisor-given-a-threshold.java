//Problem: https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/




import java.io.*;
import java.util.*;

class SmallestDivisor {
    public int minThreshold(int[] nums, int threshold) {
        int l=1, r=Integer.MIN_VALUE, divisor=-1;
        for(int i=0; i<nums.length; i++) {
            r = Math.max(nums[i], r);
        }
        while(l<=r) {
            int mid = l+(r-l)/2;
            if(isDivisible(nums, mid, threshold)) {
                divisor = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return divisor;
    }
    
    public boolean isDivisible(int[] nums, int mid, int threshold) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum+=(nums[i] + mid - 1)/mid;
            if(sum > threshold) {
               return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        SmallestDivisor divisor = new SmallestDivisor();
        int[] nums = {1,2,5,9};
        System.out.println(divisor.minThreshold(nums, 6));
        
        int[] nums1 = {44,22,33,11,1};
        System.out.println(divisor.minThreshold(nums1, 5));
        
        int[] nums2 = {21212,10101,12121};
        System.out.println(divisor.minThreshold(nums2, 1000000));
    }
}