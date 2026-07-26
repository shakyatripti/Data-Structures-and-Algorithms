//Problem: https://leetcode.com/problems/maximum-product-of-three-numbers/description





import java.io.*;
import java.util.*;


class ThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length-1, prod=1, m=nums[n], max=nums[0]*nums[1]*m;
        for(int i=1; i<=n-2; i++) {
            max=Math.max(max, nums[i]*nums[i+1]*m);
        }
        return max;
    }
}

class Main {
    public static void main(String[] args) {
        ThreeNumbers arr = new ThreeNumbers();
        int[] nums = {1,2,3};
        System.out.println(arr.maximumProduct(nums));
        
        int[] nums1 = {1,2,3,4};
        System.out.println(arr.maximumProduct(nums1));
        
        int[] nums2 = {-1,-2,-3};
        System.out.println(arr.maximumProduct(nums2));
        
        int[] nums3 = {-100,-98,-1,2,3,4};
        System.out.println(arr.maximumProduct(nums3));
    }
}