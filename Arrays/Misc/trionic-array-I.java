//Problem: https://leetcode.com/problems/trionic-array-i/description/




import java.io.*;
import java.util.*;

class TrionicArray {
    public boolean isTrionic(int[] nums) {
        int l=0, r=1;
        boolean p=false, q=false, n=false;
        while(l < nums.length && r < nums.length && nums[l] < nums[r]) {
            p = true;
            l++;
            r++;
        }
        while(l < nums.length && r < nums.length && nums[r] < nums[l]) {
            q = true;
            l++;
            r++;
        }
        while(l < nums.length && r < nums.length && nums[l] < nums[r]) {
            n = true;
            l++;
            r++;
        }

        if(!n || !q || !p || r < nums.length) {
            return false;
        }
        return true;
    }
}


class Main {
    public static void main(String[] args) {
        TrionicArray arr = new TrionicArray();
        int[] nums = {1,3,5,4,2,6};
        System.out.println(arr.isTrionic(nums));
        
        int[] nums1 = {2,1,3};
        System.out.println(arr.isTrionic(nums1)); 
        
        int[] nums2 = {8,9,4,6,1};   
        System.out.println(arr.isTrionic(nums2)); 
        
        int[] nums3 = {1,8,2,1,2,3,4};
        System.out.println(arr.isTrionic(nums3)); 
    }
}