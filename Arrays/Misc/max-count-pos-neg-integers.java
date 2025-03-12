//Problem: https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/



import java.io.*;
import java.util.*;

class MaxCount {
    public int maximumCount(int[] nums) {
        int pos = 0, neg = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                pos++;
            }
            if(nums[i] < 0) {
                neg++;
            }
        }
        return Math.max(pos, neg);
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {-1,0,0,1,2,3};
        MaxCount arr = new MaxCount();
        System.out.println(arr.maximumCount(nums));
        int[] nums2 = {-6,-2,-1,0,0,5,8};
        System.out.println(arr.maximumCount(nums2));
    }
}