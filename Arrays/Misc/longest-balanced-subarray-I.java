//Problem: https://leetcode.com/problems/longest-balanced-subarray-i/description/




import java.io.*;
import java.util.*;

class BalancedSubarrayI {
    public int longestBalanced(int[] nums) {
        int len = 0;
        for(int i=0; i<nums.length; i++) {
            Set<Integer> evens = new HashSet<>();
            Set<Integer> odds = new HashSet<>();
            for(int j=i; j<nums.length; j++) {
                if(nums[j]%2==0) {
                    evens.add(nums[j]);
                } else {
                    odds.add(nums[j]);
                }
                if(evens.size()==odds.size()) {
                    len = Math.max(len, j-i+1);
                }
            }
        }
        return len;
    }
}

class Main {
    public static void main(String[] args) {
        BalancedSubarrayI array = new BalancedSubarrayI();
        int[] nums = {2,5,4,3};
        System.out.println(array.longestBalanced(nums));
        
        int[] nums1 = {3,2,2,5,4};
        System.out.println(array.longestBalanced(nums1));
        
        int[] nums2 = {1,2,3,2};
        System.out.println(array.longestBalanced(nums2));
    }
}