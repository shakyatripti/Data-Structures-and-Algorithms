//Problem: https://leetcode.com/problems/rearrange-array-by-removing-distinct-values/description/




import java.io.*;
import java.util.*;


class RearrangeArray {
    public int[] removeValues(int[] nums) {
        int n=nums.length, k=0, maxVal=0;
        int[] ans = new int[n];
        int[] freq = new int[101];
        for(int i=0; i<nums.length; i++) {
            maxVal = Math.max(maxVal, nums[i]);
            freq[nums[i]]++;
        }

        while(k!=n) {
            for(int i=0; i<=maxVal; i++) {
                if(freq[i]!=0) {
                    ans[k] = i;
                    freq[i]--;
                    k++;
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
        RearrangeArray arr = new RearrangeArray();
        int[] nums = {3,1,3,2,1,3};
        int[] ans = arr.removeValues(nums);
        arr.display(ans);
        
        int[] nums1 = {7,7,4,4,4};
        int[] ans1 = arr.removeValues(nums1);
        arr.display(ans1);
    }
}