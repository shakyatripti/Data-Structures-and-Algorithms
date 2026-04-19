//Problem: https://leetcode.com/problems/smallest-stable-index-i/description/





import java.io.*;
import java.util.*;


class StableIndexI {
    public int firstSmallest(int[] nums, int k) {
        int n=nums.length, maxVal=0, minVal=Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            maxVal = Math.max(maxVal, nums[i]);
            minVal = Integer.MAX_VALUE;
            for(int j=i; j<n; j++) {
                minVal = Math.min(minVal, nums[j]);
            }
            int ans = maxVal - minVal;
            if(ans <= k) {
                return i;
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        StableIndexI index = new StableIndexI();
        int[] nums = {5,0,1,4};
        System.out.println(index.firstSmallest(nums, 3));
        
        int[] nums1 = {3,2,1};
        System.out.println(index.firstSmallest(nums1, 1));
        
        int[] nums2 = {0};
        System.out.println(index.firstSmallest(nums2, 0));
    }
}