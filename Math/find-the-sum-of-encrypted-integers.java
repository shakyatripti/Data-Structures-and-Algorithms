//Problem: https://leetcode.com/problems/find-the-sum-of-encrypted-integers/description/




import java.io.*;
import java.util.*;

class EncryptedIntegers {
    public int findSum(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            int maxVal = 0, n = nums[i], size = 0;
            while(n!=0) {
                int r = n%10;
                maxVal = Math.max(r, maxVal);
                size++;
                n=n/10;
            }
            String res = new String("");
            for(int j=0; j<size; j++) {
                res+=maxVal;
            }
            sum+=Integer.valueOf(res);
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        EncryptedIntegers digit = new EncryptedIntegers();
        int[] nums = {1,2,3};
        System.out.println(digit.findSum(nums));
        
        int[] nums1 = {10,21,31};
        System.out.println(digit.findSum(nums1));
    }
}