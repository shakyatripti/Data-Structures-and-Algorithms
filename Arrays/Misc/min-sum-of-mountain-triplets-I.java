//Problem: https://leetcode.com/problems/minimum-sum-of-mountain-triplets-i/description





import java.io.*;
import java.util.*;

class MountainTripletsI {
    public int minimumSum(int[] nums) {
        int sum = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    if((nums[i] < nums[j]) && (nums[k] < nums[j])) {
                        int total = nums[i] + nums[j] + nums[k];
                        sum = Math.min(sum, total);
                    }
                }
            }
        }
        return sum==Integer.MAX_VALUE ? -1 : sum;
    }
}

class Main {
    public static void main(String[] args) {
        MountainTripletsI triplets = new MountainTripletsI();
        int[] nums = {8,6,1,5,3};
        System.out.println(triplets.minimumSum(nums));
        
        int[] nums1 = {5,4,8,7,10,2};
        System.out.println(triplets.minimumSum(nums1));
        
        int[] nums2 = {6,5,4,3,4,5};
        System.out.println(triplets.minimumSum(nums2));
    }
}