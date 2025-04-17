//Problem: https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/description/



//Brute force solution
import java.io.*;
import java.util.*;

class CountEqualAndDivisiblePairs {
    public int countPairs(int[] nums, int k) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if((nums[i]==nums[j]) && (i*j)%k==0) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        CountEqualAndDivisiblePairs pairs = new CountEqualAndDivisiblePairs();
        int[] nums = {3,1,2,2,2,1,3};
        System.out.println(pairs.countPairs(nums, 2));
        
        int[] nums2 = {5,5,9,2,5,5,9,2,2,5,5,6,2,2,5,2,5,4,3};
        System.out.println(pairs.countPairs(nums2, 7));
        
        int[] nums3 = {1,2,3,4};
        System.out.println(pairs.countPairs(nums3, 1));
    }
}





//Optimal solution
import java.io.*;
import java.util.*;

class CountEqualAndDivisiblePairs {
    public int countPairs(int[] nums, int k) {
        return validPairs(nums, 0, k);
    }
    
    public int validPairs(int[] nums, int i, int k) {
        if(i==nums.length) {
            return 0;
        }
        int count = 0;
        for(int j=i+1; j<nums.length; j++) {
            if((nums[i]==nums[j]) && (i*j)%k==0) {
                count++;
            }
        }
        return count + validPairs(nums, i+1, k);
    }
}

class Main {
    public static void main(String[] args) {
        CountEqualAndDivisiblePairs pairs = new CountEqualAndDivisiblePairs();
        int[] nums = {3,1,2,2,2,1,3};
        System.out.println(pairs.countPairs(nums, 2));
        
        int[] nums2 = {5,5,9,2,5,5,9,2,2,5,5,6,2,2,5,2,5,4,3};
        System.out.println(pairs.countPairs(nums2, 7));
        
        int[] nums3 = {1,2,3,4};
        System.out.println(pairs.countPairs(nums3, 1));
    }
}