//Problem: https://leetcode.com/problems/find-the-largest-almost-missing-integer/description/


import java.io.*;
import java.util.*;

class LargestMissingInteger {
    public int missingInteger(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for(int i=0; i<=nums.length-k; i++) {
            HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
            for(int j=i; j<i+k; j++) {
                if(!visited.containsKey(nums[j])) {
                    visited.put(nums[j], true);
                    if(mp.containsKey(nums[j])) {
                        mp.put(nums[j], mp.get(nums[j]) + 1);
                    } else {
                        mp.put(nums[j], 1);
                    }
                }
            }
        }
        int ans = -1;
        for(Map.Entry entry: mp.entrySet()) {
            if((int) entry.getValue()==1) {
                ans = Math.max(ans, (int) entry.getKey());
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {3,9,2,1,7};
        LargestMissingInteger arr = new LargestMissingInteger();
        System.out.println(arr.missingInteger(nums, 3));
        
        int[] nums2 = {0,0};
        System.out.println(arr.missingInteger(nums2, 2));
    }
}