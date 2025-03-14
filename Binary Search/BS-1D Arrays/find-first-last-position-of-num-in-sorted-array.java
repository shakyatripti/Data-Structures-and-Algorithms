//Problem: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/


import java.io.*;
import java.util.*;

class FirstLastPosition {
    public int[] findFirstLastPosition(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = findFirst(nums, target);
        ans[1] = findLast(nums, target);
        return ans;
    }
    
    public int findFirst(int[] nums, int target) {
        int first=-1, l=0, r=nums.length-1;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(nums[mid] < target) {
                l = mid + 1;
            } else if(nums[mid] > target) {
                r = mid - 1;
            } else {
                first = mid;
                r = mid - 1;
            }
        }
        return first;
    }
    
    public int findLast(int[] nums, int target) {
        int last=-1, l=0, r=nums.length-1;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(nums[mid] < target) {
                l = mid + 1;
            } else if(nums[mid] > target) {
                r = mid - 1;
            } else {
                last = mid;
                l = mid + 1;
            }
        }
        return last;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,8,8,8,8,10};
        FirstLastPosition position = new FirstLastPosition();
        int[] pos = position.findFirstLastPosition(nums, 8);
        System.out.println(pos[0] + " " + pos[1]);
        
        int[] nums2 = {5,7,7,9,9,12,13};
        int[] pos1 = position.findFirstLastPosition(nums2, 7);
        System.out.println(pos1[0] + " " + pos1[1]);
        
        int[] nums3 = {3,7,8,8,9,11,17};
        int[] pos2 = position.findFirstLastPosition(nums3, 12);
        System.out.println(pos2[0] + " " + pos2[1]);
    }
}