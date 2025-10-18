
//Problem: https://leetcode.com/problems/sum-of-good-numbers/description/





import java.io.*;
import java.util.*;



class GoodNumbers {
    public int findSum(int[] nums, int k) {
        int sum = 0, n = nums.length;
        for(int i=0; i<n; i++) {
            int left = i-k, right = i+k, flag1 = 0, flag2 = 0;
            if(left >=0 && left < n && nums[i] <= nums[left]) {
                flag1 = 1;
            }
            if(right >=0 && right < n && nums[i] <= nums[right]) {
                flag2 = 1;
            }
            if(flag1==0 && flag2==0) {
                sum+=nums[i];
            }
            
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        GoodNumbers arr = new GoodNumbers();
        int[] nums = {1,3,2,1,5,4};
        System.out.println(arr.findSum(nums,2));
        
        int[] nums1 = {2,1};
        System.out.println(arr.findSum(nums1,1));
    }
}