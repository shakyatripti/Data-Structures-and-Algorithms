//Problem: https://leetcode.com/problems/smallest-absent-positive-greater-than-average/description/




import java.io.*;
import java.util.*;

class SmallestAbsent {
    public int greaterThanAvg(int[] nums) {
        int sum = 0, n = nums.length;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0; i<n; i++) {
            sum+=nums[i];
            arr.add(nums[i]);
        }
        int k = (sum/n) + 1;
        while(arr.contains(k) || k<=0) {
            k++;
        }
        return k;
    }
}

class Main {
    public static void main(String[] args) {
        SmallestAbsent arr = new SmallestAbsent();
        int[] nums = {3,5};
        System.out.println(arr.greaterThanAvg(nums));
        
        int[] nums1 = {-1,1,2};
        System.out.println(arr.greaterThanAvg(nums1));
        
        int[] nums2 = {4,-1};
        System.out.println(arr.greaterThanAvg(nums2));
    }
}