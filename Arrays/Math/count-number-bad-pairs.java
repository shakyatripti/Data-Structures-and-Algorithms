//Problem: https://leetcode.com/problems/count-number-of-bad-pairs/description/


import java.util.*;
import java.io.*;

class CountBadPairs {
    public long badPairs(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        long totalPairs = (1L*nums.length*(nums.length-1))/2, goodPairs = 0L;
        for(int i=0; i<nums.length; i++) {
            int k = nums[i] - i;
            if(mp.containsKey(k)) {
                goodPairs+=mp.get(k);
                mp.put(k, mp.get(k) + 1);
            } else {
                mp.put(k, 1);
            }
        }
        return (long) (totalPairs - goodPairs);
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {4,1,3,3};
        int[] nums1 = {1,2,3,4,5};
        CountBadPairs pairs = new CountBadPairs();
        System.out.println(pairs.badPairs(nums));
        System.out.println(pairs.badPairs(nums1));
    }
}


