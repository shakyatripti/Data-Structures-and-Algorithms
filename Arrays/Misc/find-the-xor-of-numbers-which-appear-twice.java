//Problem: https://leetcode.com/problems/find-the-xor-of-numbers-which-appear-twice/description/




import java.io.*;
import java.util.*;

class XOROfNumbers {
    public int duplicateNumbersXOR(int[] nums) {
        int[] freq = new int[51];
        int ans=0;
        for(int i=0; i<nums.length; i++) {
            freq[nums[i]]++;
        }
        for(int i=0; i<51; i++) {
            if(freq[i]==2) {
                ans = ans ^ i;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        XOROfNumbers arr = new XOROfNumbers();
        int[] nums = {1,2,1,3};
        System.out.println(arr.duplicateNumbersXOR(nums));
        
        int[] nums1 = {1,2,3};
        System.out.println(arr.duplicateNumbersXOR(nums1));
        
        int[] nums2 = {1,2,2,1};
        System.out.println(arr.duplicateNumbersXOR(nums2));
    }
}