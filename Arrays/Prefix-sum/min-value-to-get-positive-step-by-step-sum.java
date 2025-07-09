//Problem: https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/description/



import java.io.*;
import java.util.*;

class PositiveStep {
    public int minValue(int[] nums) {
        int start=0;
        int min =0;
        for(int i : nums){
            start+=i;
            min = Math.min(start,min);
        }
        return min<0?Math.abs(min)+1 : min+1;
    }
}

class Main {
    public static void main(String[] args) {
        PositiveStep step = new PositiveStep();
        int[] nums = {-3,2,-3,4,2};
        System.out.println(step.minValue(nums));
        
        int[] nums1 = {1,-2,-3};
        System.out.println(step.minValue(nums1));
        
        int[] nums2 = {1,2};
        System.out.println(step.minValue(nums2));
    }
}