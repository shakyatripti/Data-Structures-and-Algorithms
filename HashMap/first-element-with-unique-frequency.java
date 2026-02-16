//Problem: https://leetcode.com/problems/first-element-with-unique-frequency/description/





import java.io.*;
import java.util.*;

class UniqueFrequency {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        HashMap<Integer, Integer> mp = new HashMap<>();
        for(Map.Entry<Integer, Integer> it: freq.entrySet()) {
            int val = it.getValue();
            mp.put(val, mp.getOrDefault(val, 0) + 1);
        }

        for(int i=0; i<nums.length; i++) {
            int val = freq.get(nums[i]);
            if(mp.get(val)==1) {
                return nums[i];
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        UniqueFrequency arr = new UniqueFrequency();
        int[] nums = {20,10,30,30};
        System.out.println(arr.firstUniqueFreq(nums));
        
        int[] nums1 = {20,20,10,30,30,30};
        System.out.println(arr.firstUniqueFreq(nums1));
        
        int[] nums2 = {10,10,20,20};
        System.out.println(arr.firstUniqueFreq(nums2));
    }
}