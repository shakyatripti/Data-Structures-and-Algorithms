//Problem: https://leetcode.com/problems/running-sum-of-1d-array/description/




import java.io.*;
import java.util.*;


class Array1D {
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            ans[i] = nums[i] + ans[i-1];
        }
        return ans;
    }
    
    public void display(int[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Array1D arr = new Array1D();
        int[] nums = {1,2,3,4};
        int[] ans = arr.runningSum(nums);
        arr.display(ans);
        
        int[] nums1 = {1,1,1,1,1};
        int[] ans1 = arr.runningSum(nums1);
        arr.display(ans1);
        
        int[] nums2 = {3,1,2,10,1};
        int[] ans2 = arr.runningSum(nums2);
        arr.display(ans2);
    }
}