//Problem: https://leetcode.com/problems/number-of-good-pairs/description/



import java.io.*;
import java.util.*;


class GoodPairs {
    public int countIdentical(int[] nums) {
        int n=nums.length, count=0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(nums[i]==nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        GoodPairs pairs = new GoodPairs();
        int[] nums = {1,2,3,1,1,3};
        System.out.println(pairs.countIdentical(nums));
        
        int[] nums1 = {1,1,1,1};
        System.out.println(pairs.countIdentical(nums1));
        
        int[] nums2 = {1,2,3};
        System.out.println(pairs.countIdentical(nums2));
    }
}