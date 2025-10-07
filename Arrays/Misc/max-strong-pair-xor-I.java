//Problem: https://leetcode.com/problems/maximum-strong-pair-xor-i/description/





import java.io.*;
import java.util.*;

class MaxStrongPair {
    public int strongPairXor(int[] nums) {
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            for(int j=i; j<nums.length; j++) {
                if(Math.abs(nums[i]-nums[j]) <= Math.min(nums[i], nums[j])) {
                    ans = Math.max((nums[i] ^ nums[j]), ans);
                }
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        MaxStrongPair pairs = new MaxStrongPair();
        int[] nums = {1,2,3,4,5};
        System.out.println(pairs.strongPairXor(nums));
        
        int[] nums1 = {10,100};
        System.out.println(pairs.strongPairXor(nums1));
        
        int[] nums2 = {5,6,25,30};
        System.out.println(pairs.strongPairXor(nums2));
    }
}