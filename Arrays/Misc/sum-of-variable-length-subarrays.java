//Problem: https://leetcode.com/problems/sum-of-variable-length-subarrays/description/




import java.io.*;
import java.util.*;

class VariableLengthSubarrays {
    public int subarraySum(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            int start = Math.max(0, i-nums[i]);
            for(int j=start; j<=i; j++) {
                sum+=nums[j];
            }
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        VariableLengthSubarrays arr = new VariableLengthSubarrays();
        int[] nums = {2,3,1};
        System.out.println(arr.subarraySum(nums));
        
        int[] nums1 = {3,1,1,2};
        System.out.println(arr.subarraySum(nums1));
    }
}