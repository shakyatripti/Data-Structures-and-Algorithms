//Problem: https://leetcode.com/problems/find-subarrays-with-equal-sum/description/




import java.io.*;
import java.util.*;

class FindSubarray {
    public boolean equalSum(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int i=0; i<nums.length-1; i++) {
            int sum =  nums[i] + nums[i+1];
            if(st.contains(sum)) {
                return true;
            } else {
                st.add(sum);
            }
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        FindSubarray arr = new FindSubarray();
        int[] nums = {4,2,4};
        System.out.println(arr.equalSum(nums));
        
        int[] nums1 = {1,2,3,4,5};
        System.out.println(arr.equalSum(nums1));
        
        int[] nums2 = {0,0,0};
        System.out.println(arr.equalSum(nums2));
    }
}