//Problem: https://leetcode.com/problems/smallest-index-with-equal-value/description/




import java.io.*;
import java.util.*;

class EqualValue {
    public int smallestIndex(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(i % 10 ==nums[i]) {
                return i;
            }
        }    
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        EqualValue arr = new EqualValue();
        int[] nums = {0,1,2};
        System.out.println(arr.smallestIndex(nums));
        
        int[] nums1 = {4,3,2,1};
        System.out.println(arr.smallestIndex(nums1));
        
        int[] nums2 = {1,2,3,4,5,6,7,8,9,0};
        System.out.println(arr.smallestIndex(nums2));
    }
}