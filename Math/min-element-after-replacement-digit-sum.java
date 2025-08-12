//Problem: https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/description/



import java.io.*;
import java.util.*;

class ReplaceDigitSum {
    public int minElement(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            minVal = Math.min(minVal, digitSum(nums[i]));
        }
        return minVal;
    }

    public int digitSum(int n) {
        int sum = 0;
        while(n!=0) {
            int r = n%10;
            sum+=r;
            n = n/10;
        }
        return sum;
    }
}


class Main {
    public static void main(String[] args) {
        ReplaceDigitSum digit = new ReplaceDigitSum();
        int[] nums = {10,11,13,14};
        System.out.println(digit.minElement(nums));
        
        int[] nums1 = {5,8,6,3,9,33};
        System.out.println(digit.minElement(nums1));
    }
}