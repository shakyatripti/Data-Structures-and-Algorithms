//Problem: https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/description/




import java.io.*;
import java.util.*;

class SpecialArray {
    public int findValueOfX(int[] nums) {
        for(int i=0; i<=nums.length; i++) {
            int count = 0;
            for(int j=0; j<nums.length; j++) {
                if(nums[j] >= i) {
                    count++;
                }
            }
            if(count==i) {
                return i;
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        SpecialArray arr = new SpecialArray();
        int[] nums = {3,5};
        System.out.println(arr.findValueOfX(nums));
        
        int[] nums1 = {0,4,3,0,4};
        System.out.println(arr.findValueOfX(nums1));
        
        int[] nums2 = {0,0};
        System.out.println(arr.findValueOfX(nums2));
        
        int[] nums3 = {1,0,0,6,4,9};
        System.out.println(arr.findValueOfX(nums3));
        
        int[] nums4 = {3,6,7,7,0};
        System.out.println(arr.findValueOfX(nums4));
    }
}
