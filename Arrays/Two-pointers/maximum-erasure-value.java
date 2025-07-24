//Problem: https://leetcode.com/problems/maximum-erasure-value/description/




import java.io.*;
import java.util.*;

class ErasureValue {
    public int maxScore(int[] nums) {
        int l=0, r=0, sum=0, score=0;
        HashSet<Integer> seen = new HashSet<>();
        while(l < nums.length && r < nums.length) {
            while(seen.contains(nums[r])) {
                seen.remove(nums[l]);
                sum-=nums[l];
                l++;
            }
            seen.add(nums[r]);
            sum+=nums[r];
            score = Math.max(score, sum);
            r++;
        }
        return score;
    }
}


class Main {
    public static void main (String[] args) {
        ErasureValue value = new ErasureValue();
        int[] nums = {4,2,4,5,6};
        System.out.println(value.maxScore(nums));
        
        int[] nums1 = {2,1,2,2,4,8};
        System.out.println(value.maxScore(nums1));
        
        int[] nums2 = {10000,1,10000,1,1,1,1,1,1};
        System.out.println(value.maxScore(nums2));
        
        int[] nums3 = {5,2,1,2,5,2,1,2,5};
        System.out.println(value.maxScore(nums3));
    }
}