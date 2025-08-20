//Problem: https://leetcode.com/problems/minimum-average-of-smallest-and-largest-elements/description/




import java.io.*;
import java.util.*;

class SmallestLargest {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double sum = Double.MAX_VALUE;
        int n=nums.length;
        for(int i=0; i<n/2; i++) {
            double avg = (double) (nums[i] + nums[n-i-1])/2;
            sum = Math.min(avg, sum);
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        SmallestLargest element = new SmallestLargest();
        int[] nums = {7,8,3,4,15,13,4,1};
        System.out.println(element.minimumAverage(nums));
        
        int[] nums1 = {1,9,8,3,10,5,7,13};
        System.out.println(element.minimumAverage(nums1));
        
        int[] nums2 = {1,2,3,7,8,9};
        System.out.println(element.minimumAverage(nums2));
    }
}