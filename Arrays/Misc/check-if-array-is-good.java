//Problem: https://leetcode.com/problems/check-if-array-is-good/description/





import java.io.*;
import java.util.*;

class GoodArray {
    public boolean check(int[] nums) {
        int n=nums.length;
        if(n == 1) {
            return false;
        }
        int[] freq = new int[201];
        for(int i=0; i<nums.length; i++) {
            freq[nums[i]]++;
        }

        for(int i=1; i<n; i++) {
            if(i!=n-1 && freq[i]!=1) {
                return false;
            }
            if(i==n-1 && freq[i]!=2) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        GoodArray arr = new GoodArray();
        int[] nums = {2, 1, 3};
        System.out.println(arr.check(nums));
        
        int[] nums1 = {1, 3, 3, 2};
        System.out.println(arr.check(nums1));
        
        int[] nums2 = {1, 1};
        System.out.println(arr.check(nums2));
        
        int[] nums3 = {3, 4, 4, 1, 2, 1};
        System.out.println(arr.check(nums3));
    }
}