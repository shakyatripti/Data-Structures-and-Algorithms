//Problem: https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/description/




import java.io.*;
import java.util.*;

class DivideArray {
    public int minimumCost(int[] nums) {
        int ans = nums[0];
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1; i<nums.length; i++) {
            arr.add(nums[i]);
        }
        Collections.sort(arr);
        ans+=arr.get(0) + arr.get(1);
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        DivideArray arr = new DivideArray();
        int[] nums = {1,2,3,12};
        System.out.println(arr.minimumCost(nums));
        
        int[] nums1 = {5,4,3};
        System.out.println(arr.minimumCost(nums1));
        
        int[] nums2 = {10,3,1,1};
        System.out.println(arr.minimumCost(nums2));
    }
}