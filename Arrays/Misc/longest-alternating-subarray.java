//Problem: https://leetcode.com/problems/longest-alternating-subarray/description/



import java.io.*;
import java.util.*;


class AlternatingSubarray {
    public int findLongest(int[] nums) {
        int len = -1;
        for(int i=0; i<nums.length; i++) {
            int count = 0;
            for(int j=i+1; j<nums.length; j++) {
                int val = nums[j] - nums[j-1];
                if(count%2==0 && val==1) {
                    len = Math.max(len, j-i+1);
                } else if(count%2!=0 && val==-1) {
                    len = Math.max(len, j-i+1);
                } else {
                    break;
                }
                count++;
            }
        }
        return len;
    }
}

class Main {
    public static void main(String[] args) {
        AlternatingSubarray arr = new AlternatingSubarray();
        int[] nums = {2,3,4,3,4};
        System.out.println(arr.findLongest(nums));
        
        int[] nums1 = {4,5,6};
        System.out.println(arr.findLongest(nums1));
        
        int[] nums2 = {21,9,5};
        System.out.println(arr.findLongest(nums2));
    }
}