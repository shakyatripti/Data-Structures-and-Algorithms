//Problem: https://leetcode.com/problems/neither-minimum-nor-maximum/description/



import java.io.*;
import java.util.*;

class NeitherMaxNorMin {
    public int findNonMinOrMax(int[] nums) {
        int min=101, max=-1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            } 
            if(nums[i] < min) {
                min = nums[i];
            }
        }
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=min && nums[i]!=max) {
                return nums[i];
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        NeitherMaxNorMin obj = new NeitherMaxNorMin();
        int[] nums = {3,2,1,4};
        System.out.println(obj.findNonMinOrMax(nums));
        
        int[] nums1 = {1,2};
        System.out.println(obj.findNonMinOrMax(nums1));
        
        int[] nums2 = {2,1,5};
        System.out.println(obj.findNonMinOrMax(nums2));
    }
}