//Problem: https://leetcode.com/problems/build-array-from-permutation/description/



import java.io.*;
import java.util.*;

class BuildArrayFromPermutation {
    public int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }
    
    public void display(int[] res) {
        for(int i=0; i<res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.print("\n");
    }
}

class Main {
    public static void main(String[] args) {
        BuildArrayFromPermutation arr = new BuildArrayFromPermutation();
        int[] nums = {0,2,1,5,3,4};
        int[] ans = arr.buildArray(nums);
        arr.display(ans);
        
        int[] nums1 = {5,0,1,2,3,4};
        int[] ans1 = arr.buildArray(nums1);
        arr.display(ans1);
    }
}