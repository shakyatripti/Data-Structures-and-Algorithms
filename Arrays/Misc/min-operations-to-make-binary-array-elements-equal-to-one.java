//Problem: https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/


import java.io.*;
import java.util.*;

class MakeElementEquals {
    public int minOperations(int[] nums) {
        int l=0, n=nums.length, count=0;
        while(l < n) {
            if(nums[l]==0 && l+2 < n) {
                nums[l] = 1;
                nums[l+1] = 1-nums[l+1];
                nums[l+2] = 1-nums[l+2];
                count++;
            }
            l++;
        }
        if(nums[n-1]==0 || nums[n-2]==0) {
            return -1;
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,0,0};
        MakeElementEquals arr = new MakeElementEquals();
        System.out.println(arr.minOperations(nums));
        
        int[] nums2 = {1,1,1,0,0,0,1};
        System.out.println(arr.minOperations(nums2));
        
        int[] nums3 = {0,1,1,1};
        System.out.println(arr.minOperations(nums3));
    }
}