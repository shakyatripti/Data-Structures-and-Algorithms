//Problem: https://leetcode.com/problems/maximum-sum-with-exactly-k-elements/description/




import java.io.*;
import java.util.*;

class MaximizeSum {
    public int maximize(int[] nums, int k) {
        int sum=0, maxValue=0;
        for(int i=0; i<nums.length; i++) {
            maxValue = Math.max(maxValue, nums[i]);
        }
        for(int i=0; i<k; i++) {
            sum+=maxValue + i;
        }
        return sum;
    }
}


class Main {
    public static void main (String[] args) {
        MaximizeSum sum = new MaximizeSum();
        int[] nums = {1,2,3,4,5};
        System.out.println(sum.maximize(nums, 3));
        
        int[] nums1 = {5,5,5};
        System.out.println(sum.maximize(nums1, 2));
    }
}