//Problem: https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/description/



import java.io.*;
import java.util.*;

class CountPairs {
    public int lessSum(List<Integer> nums, int target) {
        int count = 0;
        for(int i=0; i<nums.size(); i++) {
            for(int j=i+1; j<nums.size(); j++) {
                if(nums.get(i) + nums.get(j) < target) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        CountPairs pairs = new CountPairs();
        List<Integer> nums = Arrays.asList(-1,1,2,3,1);
        System.out.println(pairs.lessSum(nums, 2));
        
        List<Integer> nums1 = Arrays.asList(-6,2,5,-2,-7,-1,3);
        System.out.println(pairs.lessSum(nums1, -2));
    }
}