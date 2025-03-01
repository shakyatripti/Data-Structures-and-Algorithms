//Problem: https://leetcode.com/contest/biweekly-contest-151/problems/transform-array-by-parity/description/


import java.io.*;
import java.util.*;

class TransformArray {
    public int[] transformArrayByParity(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i]%2==0) {
                nums[i] = 0;
            } else {
                nums[i] = 1;
            }
        }
        Arrays.sort(nums);
        return nums;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {3,2,7,8,10,2};
        TransformArray arr = new TransformArray();
        int[] ans = arr.transformArrayByParity(nums);
        for(int i: ans) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        int[] nums2 = {9,3,5,17,11};
        int[] ans2 = arr.transformArrayByParity(nums2);
        for(int i: ans2) {
            System.out.print(i + " ");
        }
    }
}