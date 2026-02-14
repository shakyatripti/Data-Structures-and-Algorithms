//Problem: https://leetcode.com/problems/max-pair-sum-in-an-array/description/





import java.io.*;
import java.util.*;

class PairSum {
    public int maxSum(int[] nums) {
        int res = -1;
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int digit = largestDigit(nums[i]);
            if(mp.containsKey(digit)) {
                ArrayList<Integer> arr = mp.get(digit);
                arr.add(nums[i]);
                mp.put(digit, arr);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(nums[i]);
                mp.put(digit, arr);
            }
        }

        for(Map.Entry<Integer, ArrayList<Integer>> it: mp.entrySet()) {
            ArrayList<Integer> arr = it.getValue();
            if(arr.size() > 1) {
                Collections.sort(arr);
                int sum = arr.get(arr.size()-1) + arr.get(arr.size()-2);
                res = Math.max(res, sum);
            }
        }
        return res;
    }

    public int largestDigit(int n) {
        int ans = 0;
        while(n!=0) {
            int r = n%10;
            ans = Math.max(r, ans);
            n = n/10;
        }
        return ans;
    }
}


class Main {
    public static void main(String[] args) {
        PairSum pair = new PairSum();
        int[] nums = {112,131,411};
        System.out.println(pair.maxSum(nums));
        
        int[] nums1 = {2536,1613,3366,162};
        System.out.println(pair.maxSum(nums1));
        
        int[] nums2 = {51,71,17,24,42};
        System.out.println(pair.maxSum(nums2));
    }
}