//Problem: https://leetcode.com/problems/unique-middle-element/description/





import java.io.*;
import java.util.*;


class MiddleElement {
    public boolean isUnique(int[] nums) {
        int n = nums.length, mid = n/2, count = 0;
        for(int i=0; i<n; i++) {
            if(nums[i]==nums[mid]) {
                count++;
            }

            if(count > 1) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        MiddleElement arr = new MiddleElement();
        int[] nums = {1,2,3};
        System.out.println(arr.isUnique(nums));
        
        int[] nums1 = {1,2,2};
        System.out.println(arr.isUnique(nums1));
        
        int[] nums2 = {2,3,3,4,5,5};
        System.out.println(arr.isUnique(nums2));
    }
}