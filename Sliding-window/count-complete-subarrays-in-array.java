//Problem: https://leetcode.com/problems/count-complete-subarrays-in-an-array/description/



import java.io.*;
import java.util.*;

class CountCompleteSubArrays {
    public int countSubArrays(int[] nums) {
        int distinct = 0, l=0, result=0;
        int[] freq = new int[2001];
        for(int i=0; i<nums.length; i++) {
            if(freq[nums[i]]==0) {
                distinct++;
            }
            freq[nums[i]]++;
        }
        
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            while(mp.size()==distinct) {
                result+=nums.length-i;
                mp.put(nums[l], mp.get(nums[l])-1);
                if(mp.get(nums[l])==0) {
                    mp.remove(nums[l]);
                }
                l++;
            }
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        CountCompleteSubArrays arr = new CountCompleteSubArrays();
        int[] nums = {1,3,1,2,2};
        System.out.println(arr.countSubArrays(nums));
        
        int[] nums2 = {5,5,5,5};
        System.out.println(arr.countSubArrays(nums2));
        
        int[] nums3 = {459,459,962,1579,1435,756,1872,1597};
        System.out.println(arr.countSubArrays(nums3));
    }
}