//Problem: https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations/description/




import java.io.*;
import java.util.*;

class ReverseOperations {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> arr = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            arr.add(nums[i]);
            int reverse = reverseDigit(nums[i]);
            arr.add(reverse); 
        }
        return arr.size();
    }

    public int reverseDigit(int n) {
        int num = 0;
        while(n!=0) {
            int r = n%10;
            num = (num*10 + r);
            n=n/10;
        }
        return num;
    }
}

class Main {
    public static void main(String[] args) {
        ReverseOperations arr = new ReverseOperations();
        int[] nums = {1,13,10,12,31};
        System.out.println(arr.countDistinctIntegers(nums));
        
        int[] nums1 = {2,2,2};
        System.out.println(arr.countDistinctIntegers(nums1));
    }
}