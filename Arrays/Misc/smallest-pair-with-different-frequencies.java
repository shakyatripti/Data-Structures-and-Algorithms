//Problem: https://leetcode.com/problems/smallest-pair-with-different-frequencies/description/



import java.io.*;
import java.util.*;

class DistinctFrequency {
    public int[] minPair(int[] nums) {
        int[] freq = new int[101];
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(!arr.contains(nums[i])) {
                arr.add(nums[i]);
            }
            freq[nums[i]]++;
        }
        Collections.sort(arr);
        for(int i=0; i<arr.size(); i++) {
            for(int j=0; j<arr.size(); j++) {
                int f1 = freq[arr.get(i)];
                int f2 = freq[arr.get(j)];
                if(f1!=f2) {
                    return new int[]{arr.get(i), arr.get(j)};
                }
            }
        }
        return new int[]{-1,-1};
    }
}

class Main {
    public static void main(String[] args) {
        DistinctFrequency dist = new DistinctFrequency();
        int[] nums = {1,1,2,2,3,4};
        int[] ans = dist.minPair(nums);
        System.out.println(ans[0] + " " + ans[1]);
        
        int[] nums1 = {1,5};
        int[] ans1 = dist.minPair(nums1);
        System.out.println(ans1[0] + " " + ans1[1]);
        
        int[] nums2 = {7};
        int[] ans2 = dist.minPair(nums2);
        System.out.println(ans2[0] + " " + ans2[1]);
    }
}