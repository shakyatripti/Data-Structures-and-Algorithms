//Problem: https://leetcode.com/problems/minimum-distance-to-the-target-element/description/



import java.io.*;
import java.util.*;

class TargetElement {
    public int getMinDistance(int[] nums, int target, int start) {
        int index = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            int curr = Math.abs(i-start);
            if(nums[i]==target && index >= curr) {
                index = curr;
            }
        }
        return index;
    }
}

class Main {
    public static void main(String[] args) {
        TargetElement arr = new TargetElement();
        int[] nums = {1,2,3,4,5};
        System.out.println(arr.getMinDistance(nums, 5, 3));
        
        int[] nums1 = {1};
        System.out.println(arr.getMinDistance(nums1, 1, 0));
        
        int[] nums2 = {1,1,1,1,1,1,1,1,1,1};
        System.out.println(arr.getMinDistance(nums2, 1, 0));
    }
}