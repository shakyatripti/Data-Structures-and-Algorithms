//Problem: https://leetcode.com/problems/number-of-unequal-triplets-in-array/description/




import java.io.*;
import java.util.*;

class UnequalTriplets {
    public int countInArray(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    if(nums[i]!=nums[j] && nums[j]!=nums[k] && nums[i]!=nums[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        UnequalTriplets triplets = new UnequalTriplets();
        int[] nums = {4,4,2,4,3};
        System.out.println(triplets.countInArray(nums));
        
        int[] nums1 = {1,1,1,1,1};
        System.out.println(triplets.countInArray(nums1));
    }
}