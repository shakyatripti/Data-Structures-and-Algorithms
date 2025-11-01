//Problem: https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/description/





import java.io.*;
import java.util.*;


class MakeArrayEmpty {
    public int minOperations(int[] nums) {
        int steps=0;
        Arrays.sort(nums);
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: mp.entrySet()) {
            int val = entry.getValue();
            int key = entry.getKey();
            if(val==1) {
                return -1;
            }
            if(val%3==0) {
                steps+=val/3;
            } else {
                steps+=(val/3) + 1;
            }
        }

        return steps;
    }
}

class Main {
    public static void main(String[] args) {
        MakeArrayEmpty arr = new MakeArrayEmpty();
        int[] nums = {2,3,3,2,2,4,2,3,4};
        System.out.println(arr.minOperations(nums));
        
        int[] nums1 = {2,1,2,2,3,3};
        System.out.println(arr.minOperations(nums1));
    }
}