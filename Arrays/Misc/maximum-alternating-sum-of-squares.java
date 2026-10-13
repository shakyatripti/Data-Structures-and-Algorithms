//Problem: https://leetcode.com/problems/maximum-alternating-sum-of-squares/description/




import java.io.*;
import java.util.*;


class RearrangeElements {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        long ans = 0;
        int[] posNum = new int[n];
        for(int i=0; i<n; i++) {
            posNum[i] = Math.abs(nums[i]);
        }
        Arrays.sort(posNum);

        for(int i=n-1; i>=n/2; i--) {
            ans+=posNum[i]*posNum[i];
        }

        for(int i=0; i<n/2; i++) {
            ans-=posNum[i]*posNum[i];
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        RearrangeElements arr = new RearrangeElements();
        int[] nums = {1,2,3};
        System.out.println(arr.maxAlternatingSum(nums));

        int[] nums1 = {1,-1,2,-2,3,-3};
        System.out.println(arr.maxAlternatingSum(nums1));
    }
}