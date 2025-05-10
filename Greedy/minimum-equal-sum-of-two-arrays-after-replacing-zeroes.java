//Problem: https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/description/



import java.io.*;
import java.util.*;

class MinSumReplacingZeroes {
    public long minimumSum(int[] nums1, int[] nums2) {
        long ans=0, sum1=0, sum2=0, zeroes1=0, zeroes2=0;
        for(int i=0; i<nums1.length; i++) {
            sum1+=nums1[i];
            if(nums1[i]==0) {
                zeroes1++;
            }
        }
        for(int i=0; i<nums2.length; i++) {
            sum2+=nums2[i];
            if(nums2[i]==0) {
                zeroes2++;
            }
        }
        
        sum1+=zeroes1;
        sum2+=zeroes2;
        if((sum1 < sum2 && zeroes1==0) || (sum2 < sum1 && zeroes2==0)) {
            return -1;
        }
        return Math.max(sum1, sum2);
    }
}

class Main {
    public static void main(String[] args) {
        MinSumReplacingZeroes arr = new MinSumReplacingZeroes();
        int[] nums1 = {3,2,0,1,0};
        int[] nums2 = {6,5,0};
        System.out.println(arr.minimumSum(nums1, nums2));
        
        int[] nums3 = {2,0,2,0};
        int[] nums4 = {1,4};
        System.out.println(arr.minimumSum(nums3, nums4));
        
        int[] nums5 = {0,0,10,10,12,0,13,6,0,2,10};
        int[] nums6 = {24,5,12,22};
        System.out.println(arr.minimumSum(nums5, nums6));
        
        int[] nums7 = {0,16,28,12,10,15,25,24,6,0,0};
        int[] nums8 = {20,15,19,5,6,29,25,8,12};
        System.out.println(arr.minimumSum(nums7, nums8));
        
        int[] nums9 = {8,13,15,18,0,18,0,0,5,20,12,27,3,14,22,0};
        int[] nums10 = {29,1,6,0,10,24,27,17,14,13,2,19,2,11};
        System.out.println(arr.minimumSum(nums9, nums10));
        
        int[] nums11 = {7,3,9,1,0};
        int[] nums12 = {11,9,0};
        System.out.println(arr.minimumSum(nums11, nums12));
    }
}