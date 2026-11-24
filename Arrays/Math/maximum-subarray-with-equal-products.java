//Problem: https://leetcode.com/problems/maximum-subarray-with-equal-products/description/




import java.io.*;
import java.util.*;


class EqualProductSubarray {
    public int maxLength(int[] nums) {
        int res = 0, len = 0;
        for(int i=0; i<nums.length; i++) {
            int maxVal = nums[i], gcd = nums[i], lcm = nums[i], prod = nums[i];
            for(int j=i+1; j<nums.length; j++) {
                maxVal = Math.max(maxVal, nums[j]);
                gcd = findGCD(gcd, nums[j], maxVal);
                lcm = findLCM(lcm, nums[j], maxVal);
                prod*=nums[j];
                if(prod==lcm * gcd) {
                    len = Math.max(len, j-i+1);
                }
            }
        }
        return len;
    }

    public int findGCD(int l, int r, int maxVal) {
        int ans = 0;
        for(int i=1; i<=maxVal; i++) {
            if(l%i==0 && r%i==0) {
                ans = i;
            }
        }
        return ans;
    }

    public int findLCM(int l, int r, int maxVal) {
        return l*r/findGCD(l,r,maxVal);
    }
}


class Main {
    public static void main(String[] args) {
        EqualProductSubarray arr = new EqualProductSubarray();
        int[] nums = {1,2,1,2,1,1,1};
        System.out.println(arr.maxLength(nums));
        
        int[] nums1 = {2,3,4,5,6};
        System.out.println(arr.maxLength(nums1));
        
        int[] nums2 = {1,2,3,1,4,5,1};
        System.out.println(arr.maxLength(nums2));
    }
}