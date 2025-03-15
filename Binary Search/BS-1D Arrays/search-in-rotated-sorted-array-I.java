//Problem: https://leetcode.com/problems/search-in-rotated-sorted-array/description/


import java.io.*;
import java.util.*;

class RotatedSortedArray {
    public int searchNum(int[] nums, int target) {
        int l=0, r=nums.length-1;
        while(l < r) {
            int mid = l + (r-l)/2;
            if(nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int leftSide = findNum(nums,0,r-1,target);
        int rightSide = findNum(nums,r,nums.length-1,target);
        if(leftSide==-1 && rightSide==-1) {
            return -1;
        }
        return leftSide==-1 ? rightSide : leftSide;
    }
    
    public int findNum(int[] nums, int l, int r, int target) {
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(nums[mid]==target) {
                return mid;
            } else if(nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        RotatedSortedArray arr = new RotatedSortedArray();
        System.out.println(arr.searchNum(nums,1));
        int[] nums2 = {1,3,4};
        System.out.println(arr.searchNum(nums2,0));
        
    }
}