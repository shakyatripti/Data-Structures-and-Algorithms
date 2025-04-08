//Problem: https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/



import java.io.*;
import java.util.*;

class MinOpsToMakeDistinct {
    public int minimumOperations(int[] nums) {
        int l=0, r=nums.length, operations=0;
        while(!isDistinct(nums, l, r) && l<r) {
            l+=3;
            operations++;
        } 
        return operations;
    }
    
    public boolean isDistinct(int[] nums, int l, int r) {
        int[] arr = new int[101];
        Arrays.fill(arr, -1);
        for(int i=l; i<r; i++) {
            int element = nums[i];
            if(arr[element]!=-1) {
                return false;
            }
            arr[element] = 1;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,2,3,3,5,7};
        MinOpsToMakeDistinct ans = new MinOpsToMakeDistinct();
        System.out.println(ans.minimumOperations(nums));
        
        int[] nums2 = {4,5,6,4,4};
        System.out.println(ans.minimumOperations(nums2));
        
        int[] nums3 = {6,7,8,9};
        System.out.println(ans.minimumOperations(nums3));
    }
}