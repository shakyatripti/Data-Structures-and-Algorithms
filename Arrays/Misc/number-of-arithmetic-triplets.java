//Problem: https://leetcode.com/problems/number-of-arithmetic-triplets/description/





import java.io.*;
import java.util.*;

class ArithmeticTriplets {
    public int count(int[] nums, int diff) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[j]-nums[i]==diff) {
                    for(int k=j+1; k<nums.length; k++) {
                        if(nums[k] - nums[j]==diff) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        ArithmeticTriplets triplets = new ArithmeticTriplets();
        int[] nums = {0,1,4,6,7,10};
        System.out.println(triplets.count(nums, 3));
        
        int[] nums1 = {4,5,6,7,8,9};
        System.out.println(triplets.count(nums1, 2));
    }
}