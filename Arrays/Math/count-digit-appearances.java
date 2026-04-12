//Problem: https://leetcode.com/problems/count-digit-appearances/description/




import java.io.*;
import java.util.*;

class DigitAppearances {
    public int countOccurrences(int[] nums, int digit) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            int n=nums[i];
            while(n!=0) {
                int r = n%10;
                if(r==digit) {
                    count++;
                }
                n=n/10;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        DigitAppearances arr = new DigitAppearances();
        int[] nums = {12,54,32,22};
        System.out.println(arr.countOccurrences(nums, 2));
        
        int[] nums1 = {1,34,7};
        System.out.println(arr.countOccurrences(nums1, 9));
    }
}