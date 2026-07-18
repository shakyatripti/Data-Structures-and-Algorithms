//Problem: https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/description/



import java.io.*;
import java.util.*;


class CountPairs {
    public int kDifference(int[] nums, int k) {
        int count = 0, n = nums.length;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(Math.abs(nums[i]-nums[j])==k) {
                    count++;
                }
            }
        }
        return count;
    }
}


class Main {
    public static void main(String[] args) {
        CountPairs pair = new CountPairs();
        int[] nums = {1,2,2,1};
        System.out.println(pair.kDifference(nums, 1));
        
        int[] nums1 = {1,3};
        System.out.println(pair.kDifference(nums1, 3));
        
        int[] nums2 = {3,2,1,5,4};
        System.out.println(pair.kDifference(nums2, 2));
    }
}