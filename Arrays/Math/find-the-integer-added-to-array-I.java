//Problem: https://leetcode.com/problems/find-the-integer-added-to-array-i/description/




import java.io.*;
import java.util.*;

class IntegerAdded {
    public int findX(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return nums2[0] - nums1[0];
    }
}

class Main {
    public static void main(String[] args) {
        IntegerAdded arr = new IntegerAdded();
        int[] nums1 = {2,6,4};
        int[] nums2 = {9,7,5};
        System.out.println(arr.findX(nums1, nums2));
        
        int[] nums3 = {10};
        int[] nums4 = {5};
        System.out.println(arr.findX(nums3, nums4));
        
        int[] nums5 = {1,1,1,1,1};
        int[] nums6 = {1,1,1,1,1};
        System.out.println(arr.findX(nums5, nums6));
    }
}