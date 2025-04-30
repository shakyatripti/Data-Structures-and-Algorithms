//Problem: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/


import java.io.*;
import java.util.*;

class NumberWithEvenDigits {
    public int countEvenDigits(int[] nums) {
        int count=0;
        for(int i=0; i<nums.length; i++) {
            if(isEven(nums[i])) {
                count++;
            }
        }
        return count;
    }
    
    public boolean isEven(int n) {
        int count = 0, r = 0;
        while(n!=0) {
            r = n%10;
            n=n/10;
            count++;
        }
        if(count%2==0) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        NumberWithEvenDigits digits = new NumberWithEvenDigits();
        int[] nums = {12,345,2,6,7896};
        System.out.println(digits.countEvenDigits(nums));
        
        int[] nums2 = {555,901,482,1771};
        System.out.println(digits.countEvenDigits(nums2));
    }
}