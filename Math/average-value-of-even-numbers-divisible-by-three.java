//Problem: https://leetcode.com/problems/average-value-of-even-numbers-that-are-divisible-by-three/description/



import java.io.*;
import java.util.*;

class EvenNumbers {
    public int averageValue(int[] nums) {
        int sum = 0, count = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]%2==0 && nums[i]%3==0) {
                sum+=nums[i];
                count++;
            }
        }
        if(count!=0) {
            return sum/count;
        }
        return 0;
    }
}

class Main {
    public static void main(String[] args) {
        EvenNumbers even = new EvenNumbers();
        int[] nums = {1,3,6,10,12,15};
        System.out.println(even.averageValue(nums));
        
        int[] nums1 = {1,2,4,7,10};
        System.out.println(even.averageValue(nums1));
    }
}