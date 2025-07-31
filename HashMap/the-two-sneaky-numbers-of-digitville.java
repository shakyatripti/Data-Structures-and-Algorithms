//Problem: https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/description/



import java.io.*;
import java.util.*;


class SneakyNumbers {
    public int[] getNumbers(int[] nums) {
        int[] ans = new int[2];
        int j=0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(mp.containsKey(nums[i])) {
                ans[j] = nums[i];
                j++;
            } else {
                mp.put(nums[i], 1);
            }
        }
        return ans;
    }
}


class Main {
    public static void main(String[] args) {
        SneakyNumbers obj = new SneakyNumbers();
        int[] nums = {0,1,1,0};
        int[] ans = obj.getNumbers(nums);
        System.out.println(ans[0] + " " + ans[1]);
        
        int[] nums1 = {0,3,2,1,3,2};
        int[] ans1 = obj.getNumbers(nums1);
        System.out.println(ans1[0] + " " + ans1[1]);
        
        int[] nums2 = {7,1,5,4,3,4,6,0,9,5,8,2};
        int[] ans2 = obj.getNumbers(nums2);
        System.out.println(ans2[0] + " " + ans2[1]);
    }
}