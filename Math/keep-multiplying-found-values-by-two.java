//Problem: https://leetcode.com/problems/keep-multiplying-found-values-by-two/description/




import java.io.*;
import java.util.*;

class FoundValuesByTwo {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> arr = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            arr.add(nums[i]);
        }

        int val = original;
        while(arr.contains(val)) {
            val = 2 * val;
        }
        return val;
    }
}

class Main {
    public static void main(String[] args) {
        FoundValuesByTwo arr = new FoundValuesByTwo();
        int[] nums = {5,3,6,1,12};
        System.out.println(arr.findFinalValue(nums, 3));
        
        int[] nums1 = {2,7,9};
        System.out.println(arr.findFinalValue(nums1, 4));
    }
}