//Problem: https://leetcode.com/problems/split-the-array/description/




import java.io.*;
import java.util.*;

class SplitTheArray {
    public boolean isPossibleToSplit(int[] nums) {
        int[] freq = new int[101];
        for(int i=0; i<nums.length; i++) {
            freq[nums[i]]++;
            if(freq[nums[i]] > 2) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        SplitTheArray arr = new SplitTheArray();
        int[] nums = {1,1,2,2,3,4};
        System.out.println(arr.isPossibleToSplit(nums));
        
        int[] nums1 = {1,1,1,1};
        System.out.println(arr.isPossibleToSplit(nums1));
    }
}