//Problem: https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/description/


import java.io.*;
import java.util.*;

class OrderedTriplet {
    public long maximumValue(int[] nums) {
        long triplets=0;
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    long value = (long) (nums[i]-nums[j])*nums[k];
                    triplets = Math.max(triplets, value);
                }
            }
        }
        return triplets;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {12,6,1,2,7};
        OrderedTriplet triplet = new OrderedTriplet();
        System.out.println(triplet.maximumValue(nums));
        
        int[] nums1 = {1,10,3,4,19};
        System.out.println(triplet.maximumValue(nums1));
        
        int[] nums2 = {1000000,1,1000000};
        System.out.println(triplet.maximumValue(nums2));
    }
}