//Problem: https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-i/description/





import java.io.*;
import java.util.*;

class SameScoreI {
    public int maxOperations(int[] nums) {
        int target = nums[0] + nums[1], count = 1;
        for(int i=2; i<nums.length-1; i+=2) {
            if((nums[i] + nums[i+1])==target) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        SameScoreI score = new SameScoreI();
        int[] nums = {3,2,1,4,5};
        System.out.println(score.maxOperations(nums));
        
        int[] nums1 = {1,5,3,3,4,1,3,2,2,3};
        System.out.println(score.maxOperations(nums1));
        
        int[] nums2 = {5,3};
        System.out.println(score.maxOperations(nums2));
    }
}