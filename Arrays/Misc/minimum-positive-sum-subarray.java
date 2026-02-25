//Problem: https://leetcode.com/problems/minimum-positive-sum-subarray/description/





import java.io.*;
import java.util.*;

class PositiveSumSubarray {
    public int minSum(List<Integer> nums, int l, int r) {
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<nums.size(); i++) {
            int sum = 0;
            for(int j=i; j<nums.size(); j++) {
                int len = j-i+1;
                sum+=nums.get(j);
                if(sum > 0 && len>=l && len<=r) {
                    ans = Math.min(ans, sum);
                }
            }
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}

class Main {
    public static void main(String[] args) {
        PositiveSumSubarray subarray = new PositiveSumSubarray();
        List<Integer> nums = new ArrayList<>(Arrays.asList(3,-2,1,4));
        System.out.println(subarray.minSum(nums, 2, 3));
        
        List<Integer> nums1 = new ArrayList<>(Arrays.asList(-2,2,-3,1));
        System.out.println(subarray.minSum(nums1, 2, 3));
        
        List<Integer> nums2 = new ArrayList<>(Arrays.asList(1,2,3,4));
        System.out.println(subarray.minSum(nums2, 2, 4));
    }
}