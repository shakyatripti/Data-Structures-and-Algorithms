//Problem: https://leetcode.com/problems/make-array-non-decreasing/description/


import java.io.*;
import java.util.*;

class NonDecreasingArray {
    public int maxPossibleSize(int[] nums) {
        if(isNonDecreasing(nums)) {
            return nums.length;
        }
        
        int i=1, size=1;
        while(i < nums.length && !isNonDecreasing(nums)) {
            if(nums[i] < nums[i-1]) {
                int j=i;
                while(j<nums.length && nums[j] < nums[i-1]) {
                    j++;
                }
                i=j;
            } else {
                size++;
                i++;
            }
        }
        return size;
    }
    
    public boolean isNonDecreasing(int[] nums) {
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] > nums[i+1]) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        NonDecreasingArray arr = new NonDecreasingArray();
        int[] nums = {4,2,5,3,5};
        System.out.println(arr.maxPossibleSize(nums));
        
        int[] nums2 = {2,27,15};
        System.out.println(arr.maxPossibleSize(nums2));
        
        int[] nums3 = {1,2,3};
        System.out.println(arr.maxPossibleSize(nums3));
    }
}



