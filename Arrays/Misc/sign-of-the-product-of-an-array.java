//Problem: https://leetcode.com/problems/sign-of-the-product-of-an-array/description/




import java.io.*;
import java.util.*;

class ProductOfArray {
    public int arraySign(int[] nums) {
        int prod = 1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] < 0) {
                prod*=-1;
            }
            if(nums[i]==0) {
                return 0;
            }
        }
        return prod;
    }
}

class Main {
    public static void main(String[] args) {
        ProductOfArray arr = new ProductOfArray();
        int[] nums = {-1,-2,-3,-4,3,2,1};
        System.out.println(arr.arraySign(nums));
        
        int[] nums1 = {1,5,0,2,-3};
        System.out.println(arr.arraySign(nums1));
        
        int[] nums2 = {-1,1,-1,1,-1};
        System.out.println(arr.arraySign(nums2));
    }
}