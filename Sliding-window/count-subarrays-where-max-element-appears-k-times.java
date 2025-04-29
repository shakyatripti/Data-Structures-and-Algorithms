//Problem: https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/



import java.io.*;
import java.util.*;

class CountSubArraysKMaxTimes {
    public long countSubArrays(int[] nums, int k) {
        long count=0, subarrays=0, maxValue=0;
        int l=0, r=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > maxValue) {
                maxValue = nums[i];
            }
        }
        
        while(l<nums.length && r<nums.length) {
            if(nums[r]==maxValue) {
                count++;
            }
            while(count==k) {
                subarrays+=nums.length-r;
                if(l<nums.length && nums[l]==maxValue) {
                    count--;
                }
                l++;
            }
            r++;
        }
        return subarrays;
    }
}

class Main {
    public static void main(String[] args) {
        CountSubArraysKMaxTimes arr = new CountSubArraysKMaxTimes();
        int[] nums = {1,4,2,1};
        System.out.println(arr.countSubArrays(nums, 3));
        
        int[] nums2 = {1,3,2,3,3};
        System.out.println(arr.countSubArrays(nums2, 2));
    }
}