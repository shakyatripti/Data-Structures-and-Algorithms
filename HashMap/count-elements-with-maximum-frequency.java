//Problem: https://leetcode.com/problems/count-elements-with-maximum-frequency/description/



import java.io.*;
import java.util.*;

class MaximumFrequency {
    public int countElements(int[] nums) {
        int[] freq = new int[101];
        int max=0, count=0;
        for(int i=0; i<nums.length; i++) {
            freq[nums[i]]++;
            if(max < freq[nums[i]]) {
                max = freq[nums[i]];
            }
        }

        for(int i=0; i<nums.length; i++) {
            if(freq[nums[i]]==max) {
                count++;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        MaximumFrequency arr = new MaximumFrequency();
        int[] nums = {1,2,2,3,1,4};
        System.out.println(arr.countElements(nums));
        
        int[] nums2 = {1,2,3,4,5};
        System.out.println(arr.countElements(nums2));
    }
}