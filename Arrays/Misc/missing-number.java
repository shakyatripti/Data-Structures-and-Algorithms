//Problem: https://leetcode.com/problems/missing-number/description/




import java.io.*;
import java.util.*;

class FindInArray {
    public int missingNumber(int[] nums) {
        int n=nums.length, i=0;
        Arrays.sort(nums);
        for(i=0; i<n; i++) {
            if(i!=nums[i]) {
                return i;
            }
        }
        return i;
    }
}

class Main {
    public static void main(String[] args) {
        FindInArray arr = new FindInArray();
        int[] nums = {3,0,1};
        System.out.println(arr.missingNumber(nums));
        
        int[] nums1 = {0,1};
        System.out.println(arr.missingNumber(nums1));
        
        int[] nums2 = {9,6,4,2,3,5,7,0,1};
        System.out.println(arr.missingNumber(nums2));
    }
}