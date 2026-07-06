//Problem: https://leetcode.com/problems/sum-of-integers-with-maximum-digit-range/description/



import java.io.*;
import java.util.*;


class MaxDigitRange {
    public int sumOfIntegers(int[] nums) {
        int maxVal = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int max = -1, min = Integer.MAX_VALUE, val = nums[i];
            while(val!=0) {
                int r = val % 10;
                max = Math.max(r, max);
                min = Math.min(r, min);
                val = val/10;
            }
            int diff = max - min;
            mp.put(diff, mp.getOrDefault(diff, 0) + nums[i]);
            maxVal = Math.max(diff, maxVal);
        }
        return mp.get(maxVal);
    }
}

class Main {
    public static void main(String[] args) {
        MaxDigitRange digit = new MaxDigitRange();
        int[] nums = {5724,111,350};
        System.out.println(digit.sumOfIntegers(nums));
        
        int[] nums1 = {90, 900};
        System.out.println(digit.sumOfIntegers(nums1));
    }
}