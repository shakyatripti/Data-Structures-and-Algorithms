//Problem: https://leetcode.com/problems/find-the-maximum-divisibility-score/description/




import java.io.*;
import java.util.*;

class DivisibilityScore {
    public int maxDivScore(int[] nums, int[] divisors) {
        int val = 0, ans = Integer.MAX_VALUE;
        for(int i=0; i<divisors.length; i++) {
            int count = 0;
            for(int j=0; j<nums.length; j++) {
                if(nums[j]%divisors[i]==0) {
                    count++;
                }
            }
            if(count==val) {
                val = count;
                ans = Math.min(ans, divisors[i]);
            }
            if(count > val) {
                val = count;
                ans = divisors[i];
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        DivisibilityScore arr = new DivisibilityScore();
        int[] nums = {2,9,15,50};
        int[] divisors = {5,3,7,2};
        System.out.println(arr.maxDivScore(nums, divisors));
        
        int[] nums1 = {4,7,9,3,9};
        int[] divisors1 = {5,2,3};
        System.out.println(arr.maxDivScore(nums1, divisors1));
        
        int[] nums2 = {20,14,21,10};
        int[] divisors2 = {10,16,20};
        System.out.println(arr.maxDivScore(nums2, divisors2));
    }
}