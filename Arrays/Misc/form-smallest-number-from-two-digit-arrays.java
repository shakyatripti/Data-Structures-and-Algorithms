//Problem: https://leetcode.com/problems/form-smallest-number-from-two-digit-arrays/description/




import java.io.*;
import java.util.*;


class TwoDigitArrays {
    public int smallestNum(int[] nums1, int[] nums2) {
        String ans = "";
        int[] freq = new int[10];
        int[] freq1 = new int[10];
        for(int i=0; i<nums1.length; i++) {
            freq[nums1[i]]++;
        }

        for(int i=0; i<nums2.length; i++) {
            freq1[nums2[i]]++;
        }

        for(int i=0; i<=9; i++) {
            if(freq[i] > 0 && freq1[i] > 0) {
                return i;
            }
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        char ch = (char) (nums1[0] + '0');
        char ch1 = (char) (nums2[0] + '0');
        if(nums1[0] > nums2[0]) {
            ans+=ch1;
            ans+=ch;
        } else {
            ans+=ch;
            ans+=ch1;
        }
        return Integer.valueOf(ans);
    }
}

class Main {
    public static void main(String[] args) {
        TwoDigitArrays arr = new TwoDigitArrays();
        int[] nums1 = {4,1,3};
        int[] nums2 = {5,7};
        System.out.println(arr.smallestNum(nums1, nums2));
        
        int[] nums3 = {3,5,2,6};
        int[] nums4 = {3,1,7};
        System.out.println(arr.smallestNum(nums3, nums4));
    }
}