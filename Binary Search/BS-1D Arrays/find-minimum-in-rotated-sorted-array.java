//Problem: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/


/*This solution is same as Find how many times array has been rotated*/
import java.io.*;
import java.util.*;

class RotatedSortedArray {
    public int findMinimum(int[] nums) {
        int l=0, r=nums.length-1;
        while(l<r) {
            int mid = l + (r-l)/2;
            if(nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[r];
    }
}

class Main {
    public static void main (String[] args) {
        int[] nums = {3,4,5,1,2};
        RotatedSortedArray arr = new RotatedSortedArray();
        System.out.println(arr.findMinimum(nums));
        
        int[] nums2 = {11,13,14,19};
        RotatedSortedArray arr1 = new RotatedSortedArray();
        System.out.println(arr1.findMinimum(nums2));
    }
}