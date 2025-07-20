//Problem: https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/description/




import java.io.*;
import java.util.*;

class DigitSum {
    public int smallestIndex(int[] nums) {
        int ans=-1;
        for(int i=0; i<nums.length; i++) {
            if(sumOfDigits(nums[i])==i) {
                return i;
            }
        }
        return ans;
    }

    public int sumOfDigits(int n) {
        int sum = 0;
        while(n!=0) {
           int r = n%10;
           n=n/10;
           sum+=r;
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        DigitSum digit = new DigitSum();
        int[] nums = {1,3,2};
        System.out.println(digit.smallestIndex(nums));
        
        int[] nums1 = {1,10,11};
        System.out.println(digit.smallestIndex(nums1));
        
        int[] nums2 = {8,7,6,11,5};
        System.out.println(digit.smallestIndex(nums2));
        
        int[] nums3 = {243};
        System.out.println(digit.smallestIndex(nums3));
    }
}