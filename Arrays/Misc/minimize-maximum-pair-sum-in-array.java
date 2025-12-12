//Problem: https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/description




import java.io.*;
import java.util.*;


class PairSum {
    public int minMax(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, n=nums.length;
        for(int i=0; i<n/2; i++) {
            ans = Math.max((nums[i] + nums[n-i-1]), ans);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        PairSum pair = new PairSum();
        int[] nums = {3,5,2,3};
        System.out.println(pair.minMax(nums));
        
        int[] nums1 = {3,5,4,2,4,6};
        System.out.println(pair.minMax(nums1));
    }
}