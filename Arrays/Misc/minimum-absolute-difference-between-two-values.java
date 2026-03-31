//Problem: https://leetcode.com/problems/minimum-absolute-difference-between-two-values/description/





import java.io.*;
import java.util.*;

class ZeroOneTwoArray {
    public int minAbsoluteDifference(int[] nums) {
        int diff = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums.length; j++) {
                if(nums[i]==1 && nums[j]==2) {
                    diff = Math.min(diff, Math.abs(i-j));
                }
            }
        }
        return diff==Integer.MAX_VALUE ? -1 : diff;
    }
}

class Main {
    public static void main(String[] args) {
        ZeroOneTwoArray arr = new ZeroOneTwoArray();
        int[] nums = {1,0,0,2,0,1};
        System.out.println(arr.minAbsoluteDifference(nums));
        
        int[] nums1 = {1,0,1,0};
        System.out.println(arr.minAbsoluteDifference(nums1));
    }
}