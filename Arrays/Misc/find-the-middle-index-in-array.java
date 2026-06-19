//Problem: https://leetcode.com/problems/find-the-middle-index-in-array/description/





import java.io.*;
import java.util.*;


class MiddleIndex {
    public int findInArray (int[] nums) {
        int sum = 0, left = 0, right = 0;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
        }

        for(int i=0; i<nums.length; i++) {
            sum-=nums[i];
            if(sum==left) {
                return i;
            }
            left+=nums[i];
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        MiddleIndex arr = new MiddleIndex();
        int[] nums = {2,3,-1,8,4};
        System.out.println(arr.findInArray(nums));
        
        int[] nums1 = {1,-1,4};
        System.out.println(arr.findInArray(nums1));
        
        int[] nums2 = {2,5};
        System.out.println(arr.findInArray(nums2));
    }
}