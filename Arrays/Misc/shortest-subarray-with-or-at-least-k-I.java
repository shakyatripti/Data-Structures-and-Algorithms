//Problem: https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-i/description/




import java.io.*;
import java.util.*;


class BitwiseORSubarrayI {
    public int minLength(int[] nums, int k) {
        int n=nums.length, ans=Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            int bitOR = 0;
            for(int j=i; j<n; j++) {
                bitOR = bitOR | nums[j];
                if(bitOR >= k) {
                    ans = Math.min(ans, j-i+1);
                }
            }
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}


class Main {
    public static void main(String[] args) {
        BitwiseORSubarrayI arr = new BitwiseORSubarrayI();
        int[] nums = {1,2,3};
        System.out.println(arr.minLength(nums, 2));
        
        int[] nums1 = {2,1,8};
        System.out.println(arr.minLength(nums1, 10));
        
        int[] nums2 = {1,2};
        System.out.println(arr.minLength(nums2, 0));
        
        int[] nums3 = {1,12,2,5};
        System.out.println(arr.minLength(nums3, 43));
    }
}