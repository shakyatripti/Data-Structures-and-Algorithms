//Problem: https://leetcode.com/problems/minimum-prefix-removal-to-make-array-strictly-increasing/description/




import java.io.*;
import java.util.*;

class PrefixRemoval {
    public int minLength(int[] nums) {
        int index = 0, prev = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] <= prev) {
                index = i;
            }
            prev = nums[i];
        }
        return index;
    }
}

class Main {
    public static void main(String[] args) {
        PrefixRemoval arr = new PrefixRemoval();
        int[] nums = {1,-1,2,3,3,4,5};
        System.out.println(arr.minLength(nums));
        
        int[] nums1 = {4,3,-2,-5};
        System.out.println(arr.minLength(nums1));
        
        int[] nums2 = {1,2,3,4};
        System.out.println(arr.minLength(nums2));
    }
}