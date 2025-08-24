//Problem: https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/description/




import java.io.*;
import java.util.*;

class ExceedThresholdValueI {
    public int minOperations(int[] nums, int k) {
        int operations = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] < k) {
                operations++;
            }
        }
        return operations;
    }
}

class Main {
    public static void main(String[] args) {
        ExceedThresholdValueI arr = new ExceedThresholdValueI();
        int[] nums = {2,11,10,1,3};
        System.out.println(arr.minOperations(nums, 10));
        
        int[] nums1 = {1,1,2,4,9};
        System.out.println(arr.minOperations(nums1, 1));
        
        int[] nums2 = {1,1,2,4,9};
        System.out.println(arr.minOperations(nums2, 9));
    }
}