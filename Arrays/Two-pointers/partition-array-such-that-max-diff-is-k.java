//Problem: https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/description/




import java.io.*;
import java.util.*;

class PartitionArray {
    public int maxDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0, r=0, count=0;
        while(l < nums.length && r < nums.length) {
            if(nums[r]-nums[l] <= k) {
                r++;
            } else {
                count++;
                l = r;
            }
        }
        if(r==nums.length) {
            count++;
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        PartitionArray arr = new PartitionArray();
        int[] nums = {3,6,1,2,5};
        System.out.println(arr.maxDifference(nums, 2));
        
        int[] nums1 = {2,2,4,5};
        System.out.println(arr.maxDifference(nums1, 0));
        
        int[] nums2 = {1,2,3};
        System.out.println(arr.maxDifference(nums2, 1));
    }
}