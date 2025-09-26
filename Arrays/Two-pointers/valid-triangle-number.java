//Problem: https://leetcode.com/problems/valid-triangle-number/description




import java.io.*;
import java.util.*;


class ValidTriangle {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length, count = 0;
        for(int i=n-1; i>=0; i--) {
            int l=0, r=i-1;
            while(l < r) {
                if(nums[l] + nums[r] > nums[i]) {
                    count+=r-l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return count;
    }
}


class Main {
    public static void main(String[] args) {
        ValidTriangle triangle = new ValidTriangle();
        int[] nums = {2,2,3,4};
        System.out.println(triangle.triangleNumber(nums));
        
        int[] nums1 = {4,2,3,4};
        System.out.println(triangle.triangleNumber(nums1));
        
        
        int[] nums2 = {7,0,0,0,0};
        System.out.println(triangle.triangleNumber(nums2));
        
        int[] nums3 = {24,3,82,22,35,84,19};
        System.out.println(triangle.triangleNumber(nums3));
    }
}