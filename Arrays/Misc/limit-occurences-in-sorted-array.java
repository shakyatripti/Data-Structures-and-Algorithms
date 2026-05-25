//Problem: https://leetcode.com/problems/limit-occurrences-in-sorted-array/description/




import java.io.*;
import java.util.*;

class SortedArray {
    public int[] limitOccurrences(int[] nums, int k) {
        int n=nums.length;
        int[] freq = new int[101];
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            freq[nums[i]]++;
        }
        for(int i=1; i<101; i++) {
            if(freq[i]!=0) {
                int diff = Math.min(k, freq[i]);
                for(int j=0; j<diff; j++) {
                    arr.add(i);
                }
            }
        }

        int[] ans = new int[arr.size()];
        for(int i=0; i<arr.size(); i++) { 
            ans[i] = arr.get(i);
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
        SortedArray arr = new SortedArray();
        int[] nums = {1,1,1,2,2,3};
        int[] ans = arr.limitOccurrences(nums, 2);
        arr.display(ans);
        
        int[] nums1 = {1,2,3};
        int[] ans1 = arr.limitOccurrences(nums1, 1);
        arr.display(ans1);
    }
}