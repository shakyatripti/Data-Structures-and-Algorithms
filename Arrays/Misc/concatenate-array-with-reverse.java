//Problem: https://leetcode.com/problems/concatenate-array-with-reverse/description/




import java.io.*;
import java.util.*;

class ArrayWithReverse {
    public int[] concatenate(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2*n];
        for(int i=0; i<n; i++) {
            ans[i] = nums[i];
            ans[i+n] = nums[n-i-1];
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
        ArrayWithReverse arr = new ArrayWithReverse();
        int[] nums = {1,2,3};
        int[] ans = arr.concatenate(nums);
        arr.display(ans);
        
        int[] nums1 = {1};
        int[] ans1 = arr.concatenate(nums1);
        arr.display(ans1);
    }
}