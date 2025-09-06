//Problem: https://leetcode.com/problems/number-of-distinct-averages/description/





import java.io.*;
import java.util.*;

class DistinctAverages {
    public int count(int[] nums) {
        Set<Double> st = new HashSet<>();
        int n=nums.length-1;
        Arrays.sort(nums);
        for(int i=0; i<nums.length/2; i++) {
            double val = (double) (nums[i] + nums[n-i])/2;
            st.add(val);
        }
        return st.size();
    }
}

class Main {
    public static void main(String[] args) {
        DistinctAverages avg = new DistinctAverages();
        int[] nums = {4,1,4,0,3,5};
        System.out.println(avg.count(nums));
        
        int[] nums1 = {1,100};
        System.out.println(avg.count(nums1));
        
        int[] nums2 = {9,5,7,8,7,9,8,2,0,7};
        System.out.println(avg.count(nums2));
    }
}