//Problem: https://leetcode.com/problems/minimum-value-of-merged-integers/description/




import java.io.*;
import java.util.*;


class MergedIntegers {
    public int minValue(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i+=2) {
            String curr = "";
            curr+=nums[i];
            curr+=nums[i+1];
            int val = Integer.valueOf(curr);
            ans = Math.min(val, ans);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        MergedIntegers arr = new MergedIntegers();
        int[] nums = {23,55,42,21};
        System.out.println(arr.minValue(nums));
        
        int[] nums1 = {34,7,11,11};
        System.out.println(arr.minValue(nums1));
        
        int[] nums2 = {9,20};
        System.out.println(arr.minValue(nums2));
        
        int[] nums3 = {76,55,5,4};
        System.out.println(arr.minValue(nums3));
    }
}