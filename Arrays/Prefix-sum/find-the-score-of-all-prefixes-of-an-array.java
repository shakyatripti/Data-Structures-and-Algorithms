//Problem: https://leetcode.com/problems/find-the-score-of-all-prefixes-of-an-array/description/




import java.io.*;
import java.util.*;

class ScoreOfPrefixes {
    public long[] findPrefixScore(int[] nums) {
        int n=nums.length, maxNum = 0;
        long[] ans = new long[n];
        for(int i=0; i<n; i++) {
            maxNum = Math.max(maxNum, nums[i]);
            ans[i] = maxNum + nums[i];
            if(i > 0) {
                ans[i]+=ans[i-1];
            }
        }
        return ans;
    }
    
    public void display(long[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        ScoreOfPrefixes arr = new ScoreOfPrefixes();
        int[] nums = {2,3,7,5,10};
        long[] ans = arr.findPrefixScore(nums);
        arr.display(ans);
        
        int[] nums1 = {1,1,2,4,8,16};
        long[] ans1 = arr.findPrefixScore(nums1);
        arr.display(ans1);
    }
}