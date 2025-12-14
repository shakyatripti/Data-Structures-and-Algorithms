//Problem: https://leetcode.com/problems/absolute-difference-between-maximum-and-minimum-k-elements/description




import java.io.*;
import java.util.*;

class MaxMinKElements {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int largeK = 0, smallK = 0, n = nums.length;
        for(int i=0; i<k; i++) {
            smallK+=nums[i];
        }  

        for(int i=n-1; i>=n-k; i--) {
            largeK+=nums[i];
        }
        return Math.abs(largeK - smallK);
    }
}

class Main {
    public static void main(String[] args) {
        MaxMinKElements elements = new MaxMinKElements();
        int[] nums = {5,2,2,4};
        System.out.println(elements.absDifference(nums,2));
        
        int[] nums1 = {100};
        System.out.println(elements.absDifference(nums1,1));
    }
}