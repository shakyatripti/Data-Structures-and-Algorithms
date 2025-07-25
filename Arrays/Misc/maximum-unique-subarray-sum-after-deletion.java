//Problem: https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/description/




import java.io.*;
import java.util.*;

class MaximumUniqueSubarray {
    public int maxSum(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        boolean allNegative=true;
        int ans=0, neg=-101;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                allNegative=false;
                st.add(nums[i]);
            } else {
                neg = Math.max(neg, nums[i]);
            }
        }
        if(allNegative) {
            return neg;
        }
        Iterator it = st.iterator();
        while(it.hasNext()) {
            ans+=(int) it.next();
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        MaximumUniqueSubarray subarray = new MaximumUniqueSubarray();
        int[] nums = {1,2,3,4,5};
        System.out.println(subarray.maxSum(nums));
        
        int[] nums1 = {1,1,0,1,1};
        System.out.println(subarray.maxSum(nums1));
        
        int[] nums2 = {1,2,-1,-2,1,0,-1};
        System.out.println(subarray.maxSum(nums2));
        
        int[] nums3 = {-9,-11,-2,-4,-7};
        System.out.println(subarray.maxSum(nums3));
    }
}