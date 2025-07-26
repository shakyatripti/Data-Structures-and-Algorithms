//Problem: https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/description/




import java.io.*;
import java.util.*;

class MakeArrayIncreasing {
    public int minOperations(int[] nums) {
        int val = nums[0], operations=0;
        for(int i=1; i<nums.length; i++) {
            val++;
            if(nums[i] < val) {
                operations+=val-nums[i];
            } else {
                val = nums[i];
            }
        }
        return operations;
    }
}


class Main {
    public static void main(String[] args) {
        MakeArrayIncreasing matrix = new MakeArrayIncreasing();
        int[] nums = {1,1,1};
        System.out.println(matrix.minOperations(nums));
        
        int[] nums1 = {1,5,2,4,1};
        System.out.println(matrix.minOperations(nums1));
        
        int[] nums2 = {8};
        System.out.println(matrix.minOperations(nums2));
    }
}