//Problem: https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/description/




import java.io.*;
import java.util.*;

class DivisibleByThree {
    public int minimumOperations(int[] nums) {
        int operations = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]%3!=0) {
                operations++;
            }
        }
        return operations;
    }
}

class Main {
    public static void main(String[] args) {
        DivisibleByThree obj = new DivisibleByThree();
        int[] nums = {1,2,3,4};
        System.out.println(obj.minimumOperations(nums));
        
        int[] nums1 = {3,6,9,27};
        System.out.println(obj.minimumOperations(nums1));
    }
}