//Problem: https://leetcode.com/problems/n-repeated-element-in-size-2n-array/description/





import java.io.*;
import java.util.*;

class ArrayOf2NSize {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++) {
            if(nums[i-1]==nums[i]) {
                return nums[i];
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayOf2NSize arr = new ArrayOf2NSize();
        int[] nums = {1,2,3,3};
        System.out.println(arr.repeatedNTimes(nums));
        
        int[] nums1 = {2,1,2,5,3,2};
        System.out.println(arr.repeatedNTimes(nums1));
        
        int[] nums2 = {5,1,5,2,5,3,5,4};
        System.out.println(arr.repeatedNTimes(nums2));
    }
}