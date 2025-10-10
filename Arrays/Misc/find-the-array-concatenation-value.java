//Problem: https://leetcode.com/problems/find-the-array-concatenation-value/description/





import java.util.*;
import java.io.*;

class ArrayConcatenationValue {
    public long findTheArrayConcVal(int[] nums) {
        int l=0, r=nums.length-1;
        long ans = 0;
        while(l <= r) {
            StringBuilder res = new StringBuilder();
            if(l!=r) {
               res.append(nums[l]);
               res.append(nums[r]);
            } else {
                res.append(nums[l]);
            }
            ans+=Integer.valueOf(res.toString());
            l++;
            r--;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayConcatenationValue arr = new ArrayConcatenationValue();
        int[] nums = {7,52,2,4};
        System.out.println(arr.findTheArrayConcVal(nums));
        
        int[] nums1 = {5,14,13,8,12};
        System.out.println(arr.findTheArrayConcVal(nums1));
    }
}