//Problem: https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/description/




import java.io.*;
import java.util.*;

class FindSubsequence {
    public int[] maxSum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int[] nums1 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums1);
        int j=0, n=k, m=0;
        while(k!=0) {
            int val = nums1[nums1.length-j-1];
            mp.put(val, mp.getOrDefault(val, 0) + 1);
            k--;
            j++;
        }
        
        int[] ans = new int[n];
        for(int i=0; i<nums.length; i++) {
            if(mp.containsKey(nums[i])) {
                ans[m] = nums[i];
                m++;
                if(mp.get(nums[i])-1 == 0) {
                    mp.remove(nums[i]);
                } else {
                    mp.put(nums[i], mp.get(nums[i])-1);
                }
            }
        }
        return ans;
    }
    
    public void display(int[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        FindSubsequence seq = new FindSubsequence();
        int[] nums = {3,4,3,3};
        int[] ans = seq.maxSum(nums, 2);
        seq.display(ans);
        
        int[] nums1 = {-1,-2,3,4};
        int[] ans1 = seq.maxSum(nums1, 3);
        seq.display(ans1);
        
        int[] nums2 = {-75,50};
        int[] ans2 = seq.maxSum(nums2, 2);
        seq.display(ans2);
        
        int[] nums3 = {2,1,8,7};
        int[] ans3 = seq.maxSum(nums3, 2);
        seq.display(ans3);
    }
}