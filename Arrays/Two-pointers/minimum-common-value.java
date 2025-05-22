//Problem: https://leetcode.com/problems/minimum-common-value/description/



import java.io.*;
import java.util.*;

class MinimumCommmonValue {
    public int minValue(int[] nums1, int[] nums2) {
        int p1=0, p2=0;
        while(p1 < nums1.length && p2 < nums2.length) {
            if(nums1[p1] < nums2[p2]) {
                p1++;
            } else if(nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                return nums1[p1];
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        MinimumCommmonValue val = new MinimumCommmonValue();
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4};
        System.out.println(val.minValue(nums1, nums2));
        
        int[] nums3 = {1,3,5,6,8};
        int[] nums4 = {2,5,6,11};
        System.out.println(val.minValue(nums3, nums4));
        
        int[] nums5 = {11,13,19};
        int[] nums6 = {2,3,9,10,15,18};
        System.out.println(val.minValue(nums5, nums6));
    }
}