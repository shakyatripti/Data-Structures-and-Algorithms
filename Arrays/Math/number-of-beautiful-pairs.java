//Problem: https://leetcode.com/problems/number-of-beautiful-pairs/description/



import java.io.*;
import java.util.*;


class BeautifulPairs {
    public int countTotal(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            int first = findFirstDigit(nums[i]);
            for(int j=i+1; j<nums.length; j++) {
                int last = nums[j]%10;
                if(findGCD(first, last)==1) {
                    count++;
                }
            }
        }
        return count;
    }

    public int findGCD(int n, int m) {
        int largest = Math.max(n, m), ans = 0;
        for(int i=1; i<=largest; i++) {
            if(n%i==0 && m%i==0) {
                ans = i;
            }
        }
        return ans;
    }

    public int findFirstDigit(int n) {
        int t = 0;
        while(n!=0) {
            int r = n%10;
            t=r;
            n=n/10;
        }
        return t;
    }
}

class Main {
    public static void main(String[] args) {
        BeautifulPairs pairs = new BeautifulPairs();
        int[] nums = {2,5,1,4};
        System.out.println(pairs.countTotal(nums));
        
        int[] nums1 = {11,21,12};
        System.out.println(pairs.countTotal(nums1));
        
        int[] nums2 = {31,25,72,79,74};
        System.out.println(pairs.countTotal(nums2));
    }
}