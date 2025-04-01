//Problem: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description/


import java.io.*;
import java.util.*;

class MakeArraysEqual {
    public int minimumMoves(int[] nums) {
        int n=nums.length-1, moves=0;
        Arrays.sort(nums);
        int mid = nums[n/2];
        for(int i=0; i<nums.length; i++) {
            moves+=Math.abs(nums[i]-mid);
        }
        return moves;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {1,10,2,9};
        MakeArraysEqual arr = new MakeArraysEqual();
        System.out.println(arr.minimumMoves(nums));
        
        int[] nums1 = {1,2,3};
        System.out.println(arr.minimumMoves(nums1));
        
    }
}