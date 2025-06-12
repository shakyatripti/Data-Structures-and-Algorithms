//Problem: https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/description/



import java.io.*;
import java.util.*;

class MaxDiffCircularArray {
    public int maxAdjacentDistance(int[] nums) {
        int ans = Math.abs(nums[0]-nums[nums.length-1]);
        for(int i=0; i<nums.length-1; i++) {
            int res = Math.abs(nums[i]-nums[i+1]);
            ans = Math.max(ans, res);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        MaxDiffCircularArray array = new MaxDiffCircularArray();
        int[] nums = {1,2,4};
        System.out.println(array.maxAdjacentDistance(nums));
        
        int[] nums1 = {-5,-10,-5};
        System.out.println(array.maxAdjacentDistance(nums1));
    }
}