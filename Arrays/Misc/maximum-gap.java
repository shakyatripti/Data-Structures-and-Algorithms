//Problem: https://leetcode.com/problems/maximum-gap/description/




import java.io.*;
import java.util.*;


class SortedArray {
    public int maximumGap(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++) {
            ans = Math.max(ans, nums[i]-nums[i-1]);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        SortedArray arr = new SortedArray();
        int[] nums = {3,6,9,1};
        System.out.println(arr.maximumGap(nums));
        
        int[] nums1 = {10};
        System.out.println(arr.maximumGap(nums1));
    }
}