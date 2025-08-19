//Problem: https://leetcode.com/problems/number-of-zero-filled-subarrays/description/



import java.io.*;
import java.util.*;

class ZeroFilled {
    public long countSubarrays(int[] nums) {
        long zeroes = 0, count = 0, k=1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==0) {
               count+=k;
               k++;
            } else {
               zeroes+=count;
               count=0;
               k=1;
            }
        }
        if(count!=0) {
            zeroes+=count;
        }
        return zeroes;
    }
}

class Main {
    public static void main(String[] args) {
        ZeroFilled arr = new ZeroFilled();
        int[] nums = {1,3,0,0,2,0,0,4};
        System.out.println(arr.countSubarrays(nums));
        
        int[] nums1 = {0,0,0,2,0,0};
        System.out.println(arr.countSubarrays(nums1));
        
        int[] nums2 = {2,10,2019};
        System.out.println(arr.countSubarrays(nums2));
    }
}