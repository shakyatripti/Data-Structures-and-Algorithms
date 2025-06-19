//Problem: https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/description/



//Brute Force Solution
import java.io.*;
import java.util.*;

class MakeArrayZero {
    public int subtractAmounts(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length, count=0;
        while(nums[n-1]!=0) {
            int val = 0;
            for(int i=0; i<n; i++) {
                if(nums[i]!=0) {
                    val = nums[i];
                    break;
                }
            }
            for(int i=0; i<n; i++) {
                if(nums[i]!=0) {
                    nums[i] = nums[i] - val;
                }
            }
            count++;
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        MakeArrayZero arr = new MakeArrayZero();
        int[] nums = {1,5,0,3,5};
        System.out.println(arr.subtractAmounts(nums));
        
        int[] nums1 = {0};
        System.out.println(arr.subtractAmounts(nums1));
        
        int[] nums2 = {1,2,6,8,4,2};
        System.out.println(arr.subtractAmounts(nums2));
    }
}





//Optimal Solution 
import java.io.*;
import java.util.*;

class MakeArrayZero {
    public int subtractAmounts(int[] nums) {
        int count = 0;
        int[] freq = new int[101];
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=0 && freq[nums[i]]==0) {
               count++;
            }
            freq[nums[i]]++;
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        MakeArrayZero arr = new MakeArrayZero();
        int[] nums = {1,5,0,3,5};
        System.out.println(arr.subtractAmounts(nums));
        
        int[] nums1 = {0};
        System.out.println(arr.subtractAmounts(nums1));
        
        int[] nums2 = {1,2,6,8,4,2};
        System.out.println(arr.subtractAmounts(nums2));
    }
}