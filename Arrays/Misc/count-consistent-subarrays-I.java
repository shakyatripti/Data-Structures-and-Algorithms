//Problem: https://leetcode.com/problems/count-consistent-subarrays-i/description





import java.io.*;
import java.util.*;

class ConsistentSubarraysI {
    public int count(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i],minVal = Integer.MAX_VALUE;

            for (int j = i; j < nums.length; j++) {
                sum &= nums[j];
                minVal = Math.min(nums[j], minVal);

                if (sum == minVal) {
                    count++;
                }
            }
        }

        return count;
    }
}

class Main {
    public static void main(String[] args) {
        ConsistentSubarraysI arr = new ConsistentSubarraysI();
        int[] nums = {5, 3, 1, 2};
        System.out.println(arr.count(nums));

        int[] nums1 = {1, 1, 1};
        System.out.println(arr.count(nums1));

        int[] nums2 = {0};
        System.out.println(arr.count(nums2));
    }
}