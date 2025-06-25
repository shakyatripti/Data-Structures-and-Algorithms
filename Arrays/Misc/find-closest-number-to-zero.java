//Problem: https://leetcode.com/problems/find-closest-number-to-zero/description/



import java.io.*;
import java.util.*;

class ClosestNumber {
    public int closeToZero(int[] nums) {
        int ans = Integer.MAX_VALUE, res=0;
        for(int i=0; i<nums.length; i++) {
            int val = Math.abs(nums[i]-0);
            if(val < ans) {
                ans = val;
                res = nums[i];
            } else if(val==ans) {
                res = Math.max(res, nums[i]);
            }
        }
        return res;
    }
}


class Main {
    public static void main(String[] args) {
        ClosestNumber arr = new ClosestNumber();
        int[] nums = {-4,-2,1,4,8};
        System.out.println(arr.closeToZero(nums));
        
        int[] nums1 = {-10000,-10000};
        System.out.println(arr.closeToZero(nums1));
        
        int[] nums2 = {2,-4,11,3,-2};
        System.out.println(arr.closeToZero(nums2));
        
    }
}