//Problem: https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/description/


import java.util.*;
import java.io.*;

class MaxSumPair {
    public int maximumSum(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int digits = countDigits(nums[i]);
            if(mp.containsKey(digits)) {
                mp.get(digits).add(nums[i]);
            } else {
                mp.put(digits, new ArrayList<Integer>(Arrays.asList(nums[i])));
            }
        }
        int maxSum = -1;
        for(Map.Entry<Integer, ArrayList<Integer>> entry: mp.entrySet()) {
            ArrayList<Integer> arr = entry.getValue();
            if(arr.size() >= 2) {
                Collections.sort(arr);
                int sum = arr.get(arr.size()-1) + arr.get(arr.size()-2);
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
    
    public int countDigits(int n) {
        int sum = 0, r = 0;
        while(n!=0) {
            r = n%10;
            sum+=r;
            n = n/10;
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {18,43,36,13,7,99};
        int[] nums2 = {10,12,19,14};
        MaxSumPair pair = new MaxSumPair();
        System.out.println(pair.maximumSum(nums));
        System.out.println(pair.maximumSum(nums2));
    }
}