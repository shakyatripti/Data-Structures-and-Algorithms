//Problem: https://leetcode.com/problems/construct-uniform-parity-array-ii/description




import java.io.*;
import java.util.*;


class UniformParityII {
    public boolean construct(int[] nums1) {
        int minOdd = Integer.MAX_VALUE, minEven = Integer.MAX_VALUE, n=nums1.length;

        int[] nums2 = new int[n];

        for(int i=0; i<n; i++) {
            minOdd = Math.min(minOdd, nums1[i]);
            nums2[i] = -1;
        }

        for(int i=0; i<n; i++) {
            if(nums1[i]%2==0) {
                nums2[i] = nums1[i];
            } else if(nums1[i]!=minOdd) {
                nums2[i] = nums1[i] - minOdd;
            }
        }

        if(hasAllEven(nums2)) {
            return true;
        }

        for(int i=0; i<n; i++) {
            if(nums1[i]%2!=0) {
                nums2[i] = nums1[i];
            } else if(nums1[i]!=minOdd) {
                nums2[i] = nums1[i] - minOdd;
            }
        }

        if(hasAllOdd(nums2)) {
            return true;
        }
        return false;
    }

    public boolean hasAllEven(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i] < 0 || nums[i]%2!=0) {
                return false;
            }
        }
        return true;
    }

    public boolean hasAllOdd(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i] < 0 || nums[i]%2==0) {
                return false;
            }
        }
        return true;
    }
}


class Main {
    public static void main(String[] args) {
        UniformParityII parity = new UniformParityII();
        int[] nums = {1,4,7};
        System.out.println(parity.construct(nums));
        
        int[] nums1 = {2,3};
        System.out.println(parity.construct(nums1));
        
        int[] nums2 = {4,6};
        System.out.println(parity.construct(nums2));
    }
}