//Problem: https://leetcode.com/problems/sum-of-elements-with-frequency-divisible-by-k/description/





import java.io.*;
import java.util.*;

class FrequencyDivisibleByK {
    public int sumDivisibleByK(int[] nums, int k) {
        int sum = 0;
        int[] freq = new int[101];
        for(int i=0; i<nums.length; i++) {
            freq[nums[i]]++;
        }
        for(int i=0; i<nums.length; i++) {
            if(freq[nums[i]]%k==0) {
                sum+=nums[i];
            }
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        FrequencyDivisibleByK arr = new FrequencyDivisibleByK();
        int[] nums = {1,2,2,3,3,3,3,4};
        System.out.println(arr.sumDivisibleByK(nums, 2));
        
        int[] nums1 = {1,2,3,4,5};
        System.out.println(arr.sumDivisibleByK(nums1, 2));
        
        int[] nums2 = {4,4,4,1,2,3};
        System.out.println(arr.sumDivisibleByK(nums2, 3));
    }
}