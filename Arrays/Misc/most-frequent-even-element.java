//Problem: https://leetcode.com/problems/most-frequent-even-element/description/




import java.io.*;
import java.util.*;

class MostFreqEvenNum {
    public int mostFreq(int[] nums) {
        int maxFreq=0, ans=Integer.MAX_VALUE;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(nums[i]%2==0) {
              freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
              maxFreq = Math.max(maxFreq, freq.get(nums[i]));
            }
        }
        for(int i=0; i<nums.length; i++) {
            if(nums[i]%2==0 && freq.get(nums[i])==maxFreq) {
                ans = Math.min(ans, nums[i]);
            }
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}


class Main {
    public static void main(String[] args) {
        MostFreqEvenNum evennum = new MostFreqEvenNum();
        int[] nums = {0,1,2,2,4,4,1};
        System.out.println(evennum.mostFreq(nums));
        
        int[] nums1 = {4,4,4,9,2,4};
        System.out.println(evennum.mostFreq(nums1));
        
        int[] nums2 = {29,47,21,41,13,37,25,7};
        System.out.println(evennum.mostFreq(nums2));
    }
}