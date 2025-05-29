//Problem: https://leetcode.com/problems/longest-harmonious-subsequence/description/



import java.io.*;
import java.util.*;

class HarmoniousSeq {
    public int longestSeq(int[] nums) {
        int ans=0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        for(int i=0; i<nums.length; i++) {
            if(freq.containsKey(nums[i] + 1)) {
                int count = freq.get(nums[i]) + freq.get(nums[i] + 1);
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        HarmoniousSeq subseq = new HarmoniousSeq();
        int[] nums = {1,3,2,2,5,2,3,7};
        System.out.println(subseq.longestSeq(nums));
        
        int[] nums1 = {1,2,3,4};
        System.out.println(subseq.longestSeq(nums1));
        
        int[] nums2 = {1,1,1,1};
        System.out.println(subseq.longestSeq(nums2));
    }
}