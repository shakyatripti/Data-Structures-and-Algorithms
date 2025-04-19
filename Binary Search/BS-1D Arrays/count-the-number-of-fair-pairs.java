//Problem: https://leetcode.com/problems/count-the-number-of-fair-pairs/description/



import java.io.*;
import java.util.*;

class CountFairPairs {
    public int fairPairs(int[] nums, int lower, int upper) {
        int count = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            int x = lowerBound(nums, lower, i);
            int y = upperBound(nums, upper, i);
            if(y>=x) {
                count+=y-x+1;
            }
        }
        return count;
    }
    
    public int lowerBound(int[] nums, int lower, int i) {
        int x=lower-nums[i], l=i+1, r=nums.length-1;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(nums[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    
    
    public int upperBound(int[] nums, int upper, int i) {
        int y=upper-nums[i], l=i+1, r=nums.length-1;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(nums[mid] > y) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}

class Main {
    public static void main(String[] args) {
        CountFairPairs pairs = new CountFairPairs();
        int[] nums = {0,1,7,4,4,5};
        System.out.println(pairs.fairPairs(nums, 3, 6));
        
        int[] nums2 = {1,7,9,2,5};
        System.out.println(pairs.fairPairs(nums2, 11, 11));
    }
}