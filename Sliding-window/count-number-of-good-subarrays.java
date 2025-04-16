//Problem: https://leetcode.com/problems/count-the-number-of-good-subarrays/description/



import java.io.*;
import java.util.*;

class CountGoodSubArrays {
    public long countGood(int[] nums, int k) {
        int l=0, r=0;
        long pairs=0, result=0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        while(r < nums.length) {
            pairs+=mp.getOrDefault(nums[r], 0); //count pairs will increase only when we see duplicate value
            mp.put(nums[r], mp.getOrDefault(nums[r], 0) + 1);
            while(pairs >= k) {
                result+=nums.length-r; //If till r, we get valid subarray, then after  will also be valid subarrays.
                int removed = mp.get(nums[l])-1; //Start removing elements from lth position
                if(removed == 0) { //Totally remove element if its count is 0
                    mp.remove(nums[l]);
                } else {
                    mp.put(nums[l], removed); //Otherwise, only decrese the count
                    pairs-=mp.get(nums[l]);
                }
                l++;
            }
            r++;
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        CountGoodSubArrays arr = new CountGoodSubArrays();
        int[] nums = {3,1,4,3,2,2,4};
        System.out.println(arr.countGood(nums, 2));
        
        int[] nums2 = {1,1,1,1,1};
        System.out.println(arr.countGood(nums2, 10));
    }
}