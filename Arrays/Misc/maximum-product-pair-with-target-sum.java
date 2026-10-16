//Problem: https://leetcode.com/problems/maximum-product-pair-with-target-sum/description/




import java.io.*;
import java.util.*;

class ProductPair {
    public int[] targetSum(int[] nums, int target) {
        int n=nums.length, maxProd=Integer.MIN_VALUE, p1=-1, p2=-1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i!=j && nums[i] > nums[j] && (nums[i] + nums[j] == target)) {
                    int curr = nums[i] * nums[j];
                    if(curr > maxProd) {
                        maxProd = curr;
                        p1=i;
                        p2=j;
                    }
                }
            }
        }
        return new int[]{p1, p2};
    }
}

class Main {
    public static void main(String[] args) {
        ProductPair pair = new ProductPair();
        int[] nums = {1,2,3,4};
        int[] ans = pair.targetSum(nums, 5);
        System.out.println(ans[0] + " "+ ans[1]);
        
        int[] nums1 = {-3,-1,4,2};
        int[] ans1 = pair.targetSum(nums1, 1);
        System.out.println(ans1[0] + " "+ ans1[1]);
        
        int[] nums2 = {3,3,5};
        int[] ans2 = pair.targetSum(nums2, 6);
        System.out.println(ans2[0] + " "+ ans2[1]);
    }
}
