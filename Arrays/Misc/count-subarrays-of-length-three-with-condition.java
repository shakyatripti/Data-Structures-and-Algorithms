//Problem: https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/description/



import java.io.*;
import java.util.*;

class CountSubArraysWithCondition {
    public int countValidSub(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length-2; i++) {
            if(nums[i] + nums[i+2] == (double) nums[i+1]/2) {
                count++;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        CountSubArraysWithCondition subarray = new CountSubArraysWithCondition();
        int[] nums = {1,2,1,4,1};
        System.out.println(subarray.countValidSub(nums));
        
        int[] nums2 = {-1,-4,-1,4};
        System.out.println(subarray.countValidSub(nums2));
        
        int[] nums3 = {2,-7,-6};
        System.out.println(subarray.countValidSub(nums3));
    }
}