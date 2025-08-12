//Problem: https://leetcode.com/problems/count-partitions-with-even-sum-difference/description/



import java.io.*;
import java.util.*;

class CountPartitions {
    public int evenSumDifference(int[] nums) {
        int left = 0, right = 0, count = 0;
        for(int i=0; i<nums.length; i++) {
            right+=nums[i];
        }
        for(int i=0; i<nums.length-1; i++) {
            left+=nums[i];
            right-=nums[i];
            int diff = left - right;
            if(diff%2==0) {
                count++;
            }
        }
        return count;
    }
}


class Main {
    public static void main(String[] args) {
        CountPartitions partitions = new CountPartitions();
        int[] nums = {10,10,3,7,6};
        System.out.println(partitions.evenSumDifference(nums));
        
        int[] nums1 = {1,2,2};
        System.out.println(partitions.evenSumDifference(nums1));
        
        int[] nums2 = {2,4,6,8};
        System.out.println(partitions.evenSumDifference(nums2));
    }
}