//Problem: https://leetcode.com/problems/set-mismatch/description/




import java.io.*;
import java.util.*;


class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int[] freq = new int[nums.length+1];
        for(int i=0; i<nums.length; i++) {
            freq[nums[i]]++;
        }

        for(int i=1; i<freq.length; i++) {
            if(freq[i]==0) {
                ans[1] = i;
            }
            if(freq[i]==2) {
                ans[0] = i;
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
        SetMismatch arr = new SetMismatch();
        int[] nums = {1,2,2,4};
        int[] ans = arr.findErrorNums(nums);
        arr.display(ans);
        
        int[] nums1 = {1,1};
        int[] ans1 = arr.findErrorNums(nums1);
        arr.display(ans1);
        
        int[] nums2 = {2,2};
        int[] ans2 = arr.findErrorNums(nums2);
        arr.display(ans2);
    }
}