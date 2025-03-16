//Problem: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/


import java.io.*;
import java.util.*;

class SortedRotatedArray {
    public boolean search(int[] nums, int target) {
        int l=0, r=nums.length-1;
        while(l<r) {
            while(l<r && nums[l]==nums[l+1]) {
                l++;
            }
            while(l<r && nums[r]==nums[r-1]) {
                r--;
            }
            int mid = (l+r)/2;
            if(nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        boolean leftSide = findNum(nums,0,r-1,target);
        boolean rightSide = findNum(nums,r,nums.length-1,target);
        if(rightSide || leftSide) {
            return true;
        }
        return false;
    }
    
    public boolean findNum(int[] nums, int l, int r, int target) {
        while(l <= r) {
            int mid = (l+r)/2;
            if(nums[mid]==target) {
                return true;
            } else if(nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums={1,1,1,1,2,1,1};
        SortedRotatedArray arr = new SortedRotatedArray();
        System.out.println(arr.search(nums, 2));
        
        int[] nums2 = {2,5,6,0,0,1,2};
        System.out.println(arr.search(nums2, 3));
    }
}