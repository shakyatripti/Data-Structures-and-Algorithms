//Problem: https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/




import java.io.*;
import java.util.*;


class KScores {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res=Integer.MAX_VALUE, maxVal=0, minVal=Integer.MAX_VALUE;
        for(int i=0; i<=nums.length-k; i++) {
            maxVal=0; minVal=Integer.MAX_VALUE;
            for(int j=i; j<i+k; j++) {
                maxVal = Math.max(maxVal, nums[j]);
                minVal = Math.min(minVal, nums[j]);
            }
            res = Math.min(res, (maxVal - minVal));
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        KScores scores = new KScores();
        int[] nums = {90};
        System.out.println(scores.minimumDifference(nums, 1));
        
        int[] nums1 = {9,4,1,7};
        System.out.println(scores.minimumDifference(nums1, 3));
         
        int[] nums2 = {4,9,13,1,7};
        System.out.println(scores.minimumDifference(nums2, 2));
    }
}