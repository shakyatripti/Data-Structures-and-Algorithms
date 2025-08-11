//Problem: https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/description/



import java.io.*;
import java.util.*;

class ElementAndDigitSum {
    public int differenceOfSum(int[] nums) {
        int elementSum = 0, digitSum = 0;
        for(int i=0; i<nums.length; i++) {
            elementSum+=nums[i];
            digitSum+=sumOfDigit(nums[i]);
        }
        return Math.abs(elementSum - digitSum);
    }

    public int sumOfDigit(int n) {
        int sum = 0;
        while(n!=0) {
            int r = n%10;
            sum+=r;
            n=n/10;
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        ElementAndDigitSum arr = new ElementAndDigitSum();
        int[] nums = {1,15,6,3};
        System.out.println(arr.differenceOfSum(nums));
        
        int[] nums1 = {1,2,3,4};
        System.out.println(arr.differenceOfSum(nums1));
    }
}