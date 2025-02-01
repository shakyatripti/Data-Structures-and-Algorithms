//Problem: https://leetcode.com/problems/special-array-i/description/

import java.io.*;
import java.util.*;

class SpecialArray {
    public boolean isSpecialArray(int[] nums){
        if(nums.length==1) {
            return true;
        }
        for(int i=0; i<nums.length-1; i++) {
            if((nums[i]%2==0 && nums[i+1]%2==0) || (nums[i]%2!=0 && nums[i+1]%2!=0)) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{4,3,1,6};
        int[] nums1 = new int[]{2,1,4};
        SpecialArray arr = new SpecialArray();
        System.out.println(arr.isSpecialArray(nums));
        System.out.println(arr.isSpecialArray(nums1));
    }
}