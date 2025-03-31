//Problem: https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/description


import java.io.*;
import java.util.*;

class LargestPosNegInteger {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        for(int i=nums.length-1; i>=0; i--) {
            if(nums[i] > 0 && Arrays.binarySearch(nums, -nums[i]) >= 0) {
                return nums[i];
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {-1,2,-3,3};
        LargestPosNegInteger ans = new LargestPosNegInteger();
        System.out.println(ans.findMaxK(nums));
        
        int[] nums2 = {-1,10,6,7,-7,1};
        System.out.println(ans.findMaxK(nums2));
        
        int[] nums3 = {-10,8,6,7,-2,-3};
        System.out.println(ans.findMaxK(nums3));
    }
}