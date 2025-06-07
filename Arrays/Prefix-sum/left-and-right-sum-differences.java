//Problem: https://leetcode.com/problems/left-and-right-sum-differences/description/




import java.io.*;
import java.util.*;

class LeftAndRightDiff {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=1; i<nums.length; i++) {
           left[i] = nums[i-1] + left[i-1];
        }
        for(int i=n-2; i>=0; i--) {
           right[i] = nums[i+1] + right[i+1];
        }
        for(int i=0; i<n; i++) {
            left[i] = Math.abs(left[i]-right[i]);
        }
        return left;
    }
    
    public void display(int[] ans) {
        if(ans.length==0) {
            System.out.println("empty");
        }
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.print("\n");
    }
}


class Main {
    public static void main(String[] args) {
        LeftAndRightDiff diff = new LeftAndRightDiff();
        int[] nums = {10,4,8,3};
        int[] ans = diff.leftRightDifference(nums);
        diff.display(ans);
        
        System.out.println();
        int[] nums1 = {1};
        int[] ans1 = diff.leftRightDifference(nums1);
        diff.display(ans1);
    }
}