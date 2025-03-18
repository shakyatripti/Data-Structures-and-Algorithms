//Problem: https://leetcode.com/problems/peak-index-in-a-mountain-array/description/



/*This solution is same as Find peak element*/
import java.io.*;
import java.util.*;

class PeakIndexInMountainArray {
    public int findPeak(int[] nums) {
        int l=0, r=nums.length-1;
        while(l<r) {
            int mid=(l+r)/2;
            if(nums[mid] < nums[mid+1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums={1,2,1,3,5,6,4};
        PeakIndexInMountainArray arr = new PeakIndexInMountainArray();
        System.out.println(arr.findPeak(nums));
        
        int[] nums2={0,10,5,2};
        System.out.println(arr.findPeak(nums2));
    }
}