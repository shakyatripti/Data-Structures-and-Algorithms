//Problem: https://leetcode.com/problems/maximum-difference-between-increasing-elements/description/




import java.io.*;
import java.util.*;

class IncreasingElements {
    public int maxDifference(int[] nums) {
        int ans = -1;
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[j] > nums[i]) {
                    ans = Math.max(nums[j]-nums[i], ans);
                }
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        IncreasingElements elements = new IncreasingElements();
        int[] nums = {7,1,5,4};
        System.out.println(elements.maxDifference(nums));
        
        int[] nums1 = {9,6,4,2,1};
        System.out.println(elements.maxDifference(nums1));
        
        int[] nums2 = {1,5,2,10};
        System.out.println(elements.maxDifference(nums2));
    }
}