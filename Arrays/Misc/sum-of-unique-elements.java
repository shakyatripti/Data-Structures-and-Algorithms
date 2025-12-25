//Problem: https://leetcode.com/problems/sum-of-unique-elements/description/





import java.io.*;
import java.util.*;

class UniqueElements {
    public int findSum(int[] nums) {
        int sum = 0;
        int[] freq = new int[101];
        for(int i=0; i<nums.length; i++) {
            freq[nums[i]]++;
        }
        for(int i=0; i<101; i++) {
            if(freq[i]==1) {
                sum+=i;
            }
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        UniqueElements arr = new UniqueElements();
        int[] nums = {1,2,3,2};
        System.out.println(arr.findSum(nums));
        
        int[] nums1 = {1,1,1,1,1};
        System.out.println(arr.findSum(nums1));
        
        int[] nums2 = {1,2,3,4,5};
        System.out.println(arr.findSum(nums2));
    }
}