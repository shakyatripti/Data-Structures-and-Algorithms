//Problem: https://leetcode.com/problems/check-if-bitwise-or-has-trailing-zeros/description/




import java.io.*;
import java.util.*;


class BitwiseOr {
    public boolean hasTrailingZeros(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(binaryNum(nums[i]| nums[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean binaryNum(int n) {
        StringBuilder ans = new StringBuilder("");
        while(n!=0) {
            int r = n%2;
            ans.append(r);
            n=n/2;
        }
        if(ans.charAt(0)=='0') {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        BitwiseOr arr = new BitwiseOr();
        int[] nums = {1,2,3,4,5};
        System.out.println(arr.hasTrailingZeros(nums));
        
        int[] nums1 = {2,4,8,16};
        System.out.println(arr.hasTrailingZeros(nums1));
        
        int[] nums2 = {1,3,5,7,9};
        System.out.println(arr.hasTrailingZeros(nums2));
    }
}