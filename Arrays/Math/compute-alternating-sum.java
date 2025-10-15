//Problem: https://leetcode.com/problems/compute-alternating-sum/description/





import java.io.*;
import java.util.*;

class AlternatingSum {
    public int compute(int[] nums) {
        int sum = 0, evenSum = 0, oddSum = 0;
        for(int i=0; i<nums.length; i++) {
            if(i%2==0) {
                evenSum+=nums[i];
            } else {
                oddSum+=nums[i];
            }
        }
        return evenSum - oddSum;
    }
}

class Main {
    public static void main(String[] args) {
        AlternatingSum arr = new AlternatingSum();
        int[] nums = {1,3,5,7};
        System.out.println(arr.compute(nums));
        
        int[] nums1 = {120};
        System.out.println(arr.compute(nums1));
    }
}