//Problem: https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/description/




import java.io.*;
import java.util.*;

class FinalArray {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while(k!=0) {
            int minVal = findMin(nums);
            for(int i=0; i<nums.length; i++) {
                if(nums[i]==minVal) {
                    nums[i] = nums[i]*multiplier;
                    break;
                }
            }
            k--;
        }
        return nums;
    }

    public int findMin(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            minVal = Math.min(minVal, nums[i]);
        }
        return minVal;
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
        FinalArray arr = new FinalArray();
        int[] nums = {2,1,3,5,6};
        int[] ans = arr.getFinalState(nums, 5, 2);
        arr.display(ans);
        
        int[] nums1 = {1,2};
        int[] ans1 = arr.getFinalState(nums1, 3, 4);
        arr.display(ans1);
    }
}