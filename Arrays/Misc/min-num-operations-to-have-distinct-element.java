//Problem: https://leetcode.com/problems/minimum-number-of-operations-to-have-distinct-elements/description/





import java.io.*;
import java.util.*;

class DistinctElements {
    public int minOperations(int[] nums) {
        int i=0;
        int[] freq = new int[100001];
        for(i=nums.length-1; i>=0; i--) {
            if(freq[nums[i]]==1) {
                break;
            }
            freq[nums[i]]++;
        }
        return (i+3)/3;
    }
}

class Main {
    public static void main(String[] args) {
        DistinctElements arr = new DistinctElements();
        int[] nums = {3,8,3,6,5,8};
        System.out.println(arr.minOperations(nums));
        
        int[] nums1 = {2,2};
        System.out.println(arr.minOperations(nums1));
        
        int[] nums2 = {4,3,5,1,2};
        System.out.println(arr.minOperations(nums2));
    }
}