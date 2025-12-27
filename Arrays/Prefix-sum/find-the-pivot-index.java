//Problem: https://leetcode.com/problems/find-pivot-index/description/




import java.io.*;
import java.util.*;


class PivotIndex {
    public int findPivot(int[] nums) {
        int totalSum = 0, leftSum = 0, rightSum = 0;
        for(int i=0; i<nums.length; i++) {
            totalSum+=nums[i];
        }

        for(int i=0; i<nums.length; i++) {
            rightSum=totalSum-leftSum-nums[i];
            if(leftSum==rightSum) {
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        PivotIndex arr = new PivotIndex();
        int[] nums = {1,7,3,6,5,6};
        System.out.println(arr.findPivot(nums));
        
        int[] nums1 = {1,2,3};
        System.out.println(arr.findPivot(nums1));
        
        int[] nums2 = {2,1,-1};
        System.out.println(arr.findPivot(nums2));
    }
}