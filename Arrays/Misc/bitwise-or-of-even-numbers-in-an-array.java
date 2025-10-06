//Problem: https://leetcode.com/problems/bitwise-or-of-even-numbers-in-an-array/description




import java.io.*;
import java.util.*;


class EvenNumberBitwiseOrs {
    public int calculate(int[] nums) {
        int bitWiseOrs = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]%2==0) {
                bitWiseOrs = bitWiseOrs | nums[i];
            }
        }
        return bitWiseOrs;
    }
}

class Main {
    public static void main(String[] args) {
        EvenNumberBitwiseOrs arr = new EvenNumberBitwiseOrs();
        int[] nums = {1,2,3,4,5,6};
        System.out.println(arr.calculate(nums));
        
        int[] nums1 = {7,9,11};
        System.out.println(arr.calculate(nums1));
        
        int[] nums2 = {1,8,16};
        System.out.println(arr.calculate(nums2));
    }
}