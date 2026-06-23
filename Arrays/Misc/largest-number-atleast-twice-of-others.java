//Problem: https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/




import java.io.*;
import java.util.*;


class LargestNumber {
    public int dominantIndex(int[] nums) {
        int ans = 0, index = 0;
        for(int i=0; i<nums.length; i++) {
            if(ans < nums[i]) {
                ans = nums[i];
                index = i;
            }
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=ans && 2*nums[i] > ans) {
                return -1;
            }
        }

        return index;
    }
}

class Main {
    public static void main(String[] args) {
        LargestNumber arr = new LargestNumber();
        int[] nums = {3,6,1,0};
        System.out.println(arr.dominantIndex(nums));
        
        int[] nums1 = {1,2,3,4};
        System.out.println(arr.dominantIndex(nums1));
    }
}