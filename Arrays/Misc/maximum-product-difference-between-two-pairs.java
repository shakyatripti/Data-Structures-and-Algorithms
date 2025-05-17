//Problem: https://leetcode.com/problems/maximum-product-difference-between-two-pairs/description/



import java.io.*;
import java.util.*;

class MaxProductDiff {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int nums1 = nums[0], nums2 = nums[1], nums3 = nums[nums.length-1], nums4 = nums[nums.length-2];
        return (nums3*nums4) - (nums1*nums2);
    }
}

class Main {
    public static void main(String[] args) {
        MaxProductDiff product = new MaxProductDiff();
        int[] nums = {5,6,2,7,4};
        System.out.println(product.maximumProduct(nums));
        
        int[] nums1 = {4,2,5,9,7,4,8};
        System.out.println(product.maximumProduct(nums1));
    }
}