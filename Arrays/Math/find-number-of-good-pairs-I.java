//Problem: https://leetcode.com/problems/find-the-number-of-good-pairs-i/description/




import java.io.*;
import java.util.*;

class GoodPairsI {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int count = 0;
        for(int i=0; i<nums1.length; i++) {
            for(int j=0; j<nums2.length; j++) {
                int val = nums2[j]*k;
                if(nums1[i]%val==0) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        GoodPairsI arr = new GoodPairsI();
        int[] nums1 = {1,3,4};
        int[] nums2 = {1,3,4};
        System.out.println(arr.numberOfPairs(nums1, nums2, 1));
        
        int[] nums3 = {1,2,4,12};
        int[] nums4 = {2,4};
        System.out.println(arr.numberOfPairs(nums3, nums4, 3));
    }
}