//Problem: https://leetcode.com/problems/difference-between-peaks-and-valleys/description/





import java.io.*;
import java.util.*;

class PeaksAndValleys {
    public int findDifference(int[] nums) {
        int peaks=0, valleys=0;
        for(int i=1; i<nums.length-1; i++) {
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                peaks+=nums[i];
            }
            if(nums[i] < nums[i-1] && nums[i] < nums[i+1]) {
                valleys+=nums[i];
            }
        }
        return peaks-valleys;
    }
}

class Main {
    public static void main(String[] args) {
        PeaksAndValleys arr = new PeaksAndValleys();
        int[] nums = {1,5,2,4,1,3,0};
        System.out.println(arr.findDifference(nums));
        
        int[] nums1 = {-5,-6,-1,-2,5,3,2};
        System.out.println(arr.findDifference(nums1));
        
        int[] nums2 = {6,5,2,5,5,3,6};
        System.out.println(arr.findDifference(nums2));
    }
}