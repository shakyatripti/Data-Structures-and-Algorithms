//Problem: https://leetcode.com/problems/minimum-pair-removal-to-sort-array-i/description/



import java.io.*;
import java.util.*;

class MinPairRemoval {
    public int minimumOperations(int[] nums) {
        int operations = 0;
        while(!isNonDecreasing(nums)) {
            int minSum = Integer.MAX_VALUE, minIndex = 0, index = 0;
            for(int i=0; i<nums.length-1; i++) {
                if(minSum > nums[i] + nums[i+1]) {
                    minSum = nums[i] + nums[i+1];
                    minIndex = i;
                }
            }
            
            int[] newNums = new int[nums.length-1];
            for(int i=0; i<nums.length; i++) {
                if(i!=minIndex) {
                    newNums[index] = nums[i];
                } else {
                    newNums[index] = minSum;
                    i++;
                }
                index++;
            }
            nums = newNums;
            operations++;
        }
        return operations;
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
        int[] nums = {5,2,3,1};
        MinPairRemoval pair = new MinPairRemoval();
        System.out.println(pair.minimumOperations(nums));
        
        int[] nums1 = {2,2,-1,3,-2,2,1,1,1,0,-1};
        System.out.println(pair.minimumOperations(nums1));
        
        int[] nums2 = {1,2,2};
        System.out.println(pair.minimumOperations(nums2));
    }
}