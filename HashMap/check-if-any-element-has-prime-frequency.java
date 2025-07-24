//Problem: https://leetcode.com/problems/check-if-any-element-has-prime-frequency/description/




import java.io.*;
import java.util.*;

class PrimeFrequency {
    public boolean check(int[] nums) {
        int[] freq = new int[101];
        for(int i=0; i<nums.length; i++) {
            freq[nums[i]]++;
        }
        for(int i=0; i<nums.length; i++) {
            if(isPrime(freq[nums[i]])) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isPrime(int n) {
        if(n<2) return false;
        if(n==2) return true;
        if(n%2==0) return false;
        for(int i=3; i*i<=n; i+=2) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        PrimeFrequency arr = new PrimeFrequency();
        int[] nums = {1,2,3,4,5,4};
        System.out.println(arr.check(nums));
        
        int[] nums1 = {1,2,3,4,5};
        System.out.println(arr.check(nums1));
        
        int[] nums2 = {2,2,2,4,4};
        System.out.println(arr.check(nums2));
    }
}