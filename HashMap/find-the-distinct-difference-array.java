//Problem: https://leetcode.com/problems/find-the-distinct-difference-array/description/




import java.io.*;
import java.util.*;

class DifferenceArray {
    public int[] distinct(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            int prefix = frequency(0, i+1, nums);
            int suffix = frequency(i+1, nums.length, nums);
            ans[i] = prefix - suffix;
        }
        return ans;
    }

    public int frequency(int l, int r, int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=l; i<r; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        return mp.size();
    }
    
    public void display(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main (String[] args) {
        DifferenceArray arr = new DifferenceArray();
        int[] nums = {1,2,3,4,5};
        int[] ans = arr.distinct(nums);
        arr.display(ans);
        
        int[] nums1 = {3,2,3,4,2};
        int[] ans1 = arr.distinct(nums1);
        arr.display(ans1);
        
    }
}