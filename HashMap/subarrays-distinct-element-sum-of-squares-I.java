//Problem: https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/description/





import java.io.*;
import java.util.*;

class SumOfSquaresI {
    public int sumDistinct(List<Integer> nums) {
        int sum = 0;
        for(int i=0; i<nums.size(); i++) {
            HashMap<Integer, Integer> mp = new HashMap<>();
            for(int j=i; j<nums.size(); j++) {
                mp.put(nums.get(j), mp.getOrDefault(nums.get(j), 0) + 1);
                sum+=mp.size()*mp.size();
            }
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        SumOfSquaresI arr = new SumOfSquaresI();
        List<Integer> nums = new ArrayList(Arrays.asList(1,2,1));
        System.out.println(arr.sumDistinct(nums));
        
        List<Integer> nums1 = new ArrayList(Arrays.asList(1,1));
        System.out.println(arr.sumDistinct(nums1));
    }
}