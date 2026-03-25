//Problem: https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/description/



import java.io.*;
import java.util.*;

class ElementsInArray {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int a = nums[nums.length-1] - 1;
        int b = nums[nums.length-2] - 1;
        return a*b;
    }
}

class Main {
    public static void main(String[] args) {
        ElementsInArray arr = new ElementsInArray();
        int[] nums = {3,4,5,2};
        System.out.println(arr.maxProduct(nums));

        int[] nums1 = {1,5,4,5};
        System.out.println(arr.maxProduct(nums1));

        int[] nums2 = {3,7};
        System.out.println(arr.maxProduct(nums2));
    }
}