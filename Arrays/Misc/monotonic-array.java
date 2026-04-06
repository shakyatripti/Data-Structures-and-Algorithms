//Problem: https://leetcode.com/problems/monotonic-array/description/



import java.io.*;
import java.util.*;

class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        int increase=0, decrease=0, n=nums.length;
        for(int i=0; i<n-1; i++) {
            if(nums[i] < nums[i+1]) {
                increase++;
            } else if(nums[i] > nums[i+1]) {
                decrease++;
            } else {
                increase++;
                decrease++;
            }
        }

        if(increase==n-1 || decrease==n-1) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        MonotonicArray arr = new MonotonicArray();
        int[] nums = {1,2,2,3};
        System.out.println(arr.isMonotonic(nums));
        
        int[] nums1 = {6,5,4,4};
        System.out.println(arr.isMonotonic(nums1));
        
        int[] nums2 = {1,3,2};
        System.out.println(arr.isMonotonic(nums2));
    }
}