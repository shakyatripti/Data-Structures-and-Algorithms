//Problem: https://leetcode.com/problems/max-consecutive-ones/description/


import java.util.*;
import java.io.*;

class MaxConsecutiveOnes {
    public int countOnes(int[] nums) {
        int count = 0, ones=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==1) {
                ones++;
                count=Math.max(ones, count);
            } else {
                ones = 0;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,0,1,1,1,0};
        MaxConsecutiveOnes arr = new MaxConsecutiveOnes();
        System.out.println(arr.countOnes(nums));
    }
}