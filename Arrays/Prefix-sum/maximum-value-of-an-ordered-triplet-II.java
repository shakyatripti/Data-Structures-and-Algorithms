//Problem: https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/description/


import java.io.*;
import java.util.*;

class MaxOrderedTriplet {
    public long maximumTripletValue(int[] nums) {
        int[] leftMax = new int[nums.length];
        int[] rightMax = new int[nums.length];
        long result = 0;
        for(int i=nums.length-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], nums[i+1]);
        }
        for(int i=0; i<nums.length; i++) {
            if(i==0) {
                leftMax[0] = 0;
            } else {
                leftMax[i] = Math.max(leftMax[i-1], nums[i-1]);
            }
            long value = (long) (leftMax[i] - nums[i])*rightMax[i];
            result = Math.max(result, value);
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {12,6,1,2,7};
        MaxOrderedTriplet triplet = new MaxOrderedTriplet();
        System.out.println(triplet.maximumTripletValue(nums));
        
        int[] nums2 = {1,10,3,4,19};
        System.out.println(triplet.maximumTripletValue(nums2));
        
        int[] nums3 = {1,2,3};
        System.out.println(triplet.maximumTripletValue(nums3));
    }
}