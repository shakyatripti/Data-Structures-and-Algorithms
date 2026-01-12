//Problem: https://leetcode.com/problems/number-of-centered-subarrays/description/





import java.io.*;
import java.util.*;

class CenteredSubarrays {
    public int countSubarrays(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            int sum = 0;
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j=i; j<nums.length; j++) {
                sum+=nums[j];
                arr.add(nums[j]);
                if(arr.contains(sum)) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        CenteredSubarrays arr = new CenteredSubarrays();
        int[] nums = {-1,1,0};
        System.out.println(arr.countSubarrays(nums));
        
        int[] nums1 = {2,-3};
        System.out.println(arr.countSubarrays(nums1));
    }
}