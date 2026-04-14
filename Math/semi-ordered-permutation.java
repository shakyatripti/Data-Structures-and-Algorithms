//Problem: https://leetcode.com/problems/semi-ordered-permutation/description




import java.io.*;
import java.util.*;


class SemiOrderedPermutation {
    public int minOperations(int[] nums) {
        int x=0, y=0, n=nums.length;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==1) {
                x = i;
            }
            if(nums[i]==n) {
                y = i;
            }
        }

        if(x < y) {
            return x + (n-y-1);
        }
        return x + (n-y-1) - 1;
    }
}

class Main {
    public static void main(String[] args) {
        SemiOrderedPermutation perm = new SemiOrderedPermutation();
        int[] nums = {2,1,4,3};
        System.out.println(perm.minOperations(nums));
        
        int[] nums1 = {2,4,1,3};
        System.out.println(perm.minOperations(nums1));
        
        int[] nums2 = {1,3,4,2,5};
        System.out.println(perm.minOperations(nums2));
    }
}