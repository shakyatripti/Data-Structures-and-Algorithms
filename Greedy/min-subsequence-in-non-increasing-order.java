//Problem: https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/description/




import java.io.*;
import java.util.*;

class NonIncreasingOrder {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int totalSum = 0, sum=0;
        for(int i=0; i<nums.length; i++) {
           totalSum+=nums[i];
        }
        for(int i=nums.length-1; i>=0; i--) {
            totalSum-=nums[i];
            sum+=nums[i];
            if(totalSum >= sum) {
                ans.add(nums[i]);
            } else {
                ans.add(nums[i]);
                return ans;
            }
        }
        return ans;
    }
    
    public void display(List<Integer> ans) {
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        NonIncreasingOrder subseq = new NonIncreasingOrder();
        int[] nums = {4,3,10,9,8};
        List<Integer> ans = subseq.minSubsequence(nums);
        subseq.display(ans);
        
        int[] nums1 = {4,4,7,6,7};
        List<Integer> ans1 = subseq.minSubsequence(nums1);
        subseq.display(ans1);
    }
}