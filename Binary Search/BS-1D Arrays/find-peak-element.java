//Problem: https://leetcode.com/problems/find-peak-element/description/



/*The solution is same as Peak Index in a mountain array*/
import java.io.*;
import java.util.*;

class PeakIndex {
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
        PeakIndex arr = new PeakIndex();
        System.out.println(arr.findPeak(nums));
        
        int[] nums2={1,2,3,1};
        System.out.println(arr.findPeak(nums2));
    }
}