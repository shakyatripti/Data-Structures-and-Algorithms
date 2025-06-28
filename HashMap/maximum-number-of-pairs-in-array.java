//Problem: https://leetcode.com/problems/maximum-number-of-pairs-in-array/description/




import java.io.*;
import java.util.*;

class MaxPairsInArray {
    public int[] numberOfPairs(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        int[] ans = new int[2];
        int leftOver=0;
        for(Map.Entry entry: mp.entrySet()) {
            int val = (int) entry.getValue();
            if(val%2!=0) {
               leftOver++;
            }
        }
        int pairs = (nums.length - leftOver)/2;
        ans[0] = pairs;
        ans[1] = leftOver;
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        MaxPairsInArray arr = new MaxPairsInArray();
        int[] nums = {1,3,2,1,3,2,2};
        int[] ans = arr.numberOfPairs(nums);
        System.out.println(ans[0] + " " + ans[1]);
        
        int[] nums2 = {1,1};
        int[] ans2 = arr.numberOfPairs(nums2);
        System.out.println(ans2[0] + " " + ans2[1]);
        
        int[] nums3 = {0};
        int[] ans3 = arr.numberOfPairs(nums3);
        System.out.println(ans3[0] + " " + ans3[1]);
    }
}