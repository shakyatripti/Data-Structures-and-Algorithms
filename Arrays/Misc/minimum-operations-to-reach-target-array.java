//Problem: https://leetcode.com/problems/minimum-operations-to-reach-target-array/description/






import java.io.*;
import java.util.*;


class TargetArray {
    public int minOperations(int[] nums, int[] target) {
        Set<Integer> st = new HashSet<>();
        int n=nums.length;
        for(int i=0; i<n; i++) {
            if(nums[i]!=target[i]) {
                st.add(nums[i]);
            }
        }
        return st.size();
    }
}

class Main {
    public static void main(String[] args) {
        TargetArray arr = new TargetArray();
        int[] nums = {1,2,3};
        int[] target = {2,1,3};
        System.out.println(arr.minOperations(nums, target));
        
        int[] nums1 = {4,1,4};
        int[] target1 = {5,1,4};
        System.out.println(arr.minOperations(nums1, target1));
        
        int[] nums2 = {7,3,7};
        int[] target2 = {5,5,9};
        System.out.println(arr.minOperations(nums2, target2));
    }
}