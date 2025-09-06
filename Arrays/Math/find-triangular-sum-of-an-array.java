//Problem: https://leetcode.com/problems/find-triangular-sum-of-an-array/description/





import java.io.*;
import java.util.*;

class TriangularSum {
    public int sum(int[] nums) {
        int n=nums.length-1;
        for(int i=0; i<n; i++) {
            int[] ans = new int[nums.length-1];
            for(int j=0; j<nums.length-1; j++) {
                ans[j] = (nums[j] + nums[j+1])%10;
            }
            nums = ans;
        }
        return nums[0];
    }
}

class Main {
    public static void main(String[] args) {
        TriangularSum arr = new TriangularSum();
        int[] nums = {1,2,3,4,5};
        System.out.println(arr.sum(nums));
        
        int[] nums1 = {6};
        System.out.println(arr.sum(nums1));
    }
}