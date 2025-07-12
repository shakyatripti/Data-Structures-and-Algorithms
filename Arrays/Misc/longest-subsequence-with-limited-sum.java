//Problem: https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/



import java.io.*;
import java.util.*;

class LongestSubsequence {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] ans = new int[queries.length];
        Arrays.sort(nums);
        for(int i=0; i<queries.length; i++) {
            int sum = 0, count = 0;
            for(int j=0; j<nums.length; j++) {
                sum+=nums[j];
                if(sum <= queries[i]) {
                    count++;
                } else {
                    break;
                }
            }
            ans[i] = count;
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
        LongestSubsequence subseq = new LongestSubsequence();
        int[] nums = {4,5,2,1};
        int[] queries = {3,10,21};
        int[] ans = subseq.answerQueries(nums, queries);
        subseq.display(ans);
        
        int[] nums1 = {736411,184882,914641,37925,214915};
        int[] queries1 = {331244,273144,118983,118252,305688,718089,665450};
        int[] ans1 = subseq.answerQueries(nums1, queries1);
        subseq.display(ans1);
        
        int[] nums2 = {2,3,4,5};
        int[] queries2 = {1};
        int[] ans3 = subseq.answerQueries(nums2, queries2);
        subseq.display(ans3);
    }
}