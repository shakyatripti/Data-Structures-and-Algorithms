//Problem:https://leetcode.com/problems/find-greatest-common-divisor-of-array/




import java.io.*;
import java.util.*;


class Array {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int largest = nums[nums.length-1], smallest = nums[0], ans = 1;
        for(int i=1; i<=largest; i++) {
            if(largest%i==0 && smallest%i==0) {
                ans = Math.max(ans, i);
            }
        }  
        return ans;
    }
} 

class Main {
    public static void main(String[] args) {
        Array arr = new Array();
        int[] nums = {2,5,6,9,10};
        System.out.println(arr.findGCD(nums));
        
        int[] nums1 = {7,5,6,8,3};
        System.out.println(arr.findGCD(nums1));
        
        int[] nums2 = {3,3};
        System.out.println(arr.findGCD(nums2));
    }
}