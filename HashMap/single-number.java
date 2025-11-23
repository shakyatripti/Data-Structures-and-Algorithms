//Problem: https://leetcode.com/problems/single-number/description/




import java.io.*;
import java.util.*;

class SingleNumber {
    public int isSingle(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: mp.entrySet()) {
            if(entry.getValue()==1) {
                return entry.getKey();
            }
        }
        return 0;
    }
}

class Main {
    public static void main(String[] args) {
        SingleNumber arr = new SingleNumber();
        int[] nums = {2,2,1};
        System.out.println(arr.isSingle(nums));
        
        int[] nums1 = {4,1,2,1,2};
        System.out.println(arr.isSingle(nums1));
        
        int[] nums2 = {1};
        System.out.println(arr.isSingle(nums2));
    }
}