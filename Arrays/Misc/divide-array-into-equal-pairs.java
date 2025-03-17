//Problem: https://leetcode.com/problems/divide-array-into-equal-pairs/description/



//Brute Force solution
import java.io.*;
import java.util.*;

class DivideArrayIntoPairs {
    public boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        
        for(Map.Entry entry: mp.entrySet()) {
            int val = (int) entry.getValue();
            if(val%2!=0) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        DivideArrayIntoPairs arr = new DivideArrayIntoPairs();
        int[] nums = {3,2,3,2,2,2};
        System.out.println(arr.divideArray(nums));
        
        int[] nums2 = {1,2,2,5,6,5};
        System.out.println(arr.divideArray(nums2));
    }
}