//Problem: https://leetcode.com/problems/compare-sums-of-bitonic-parts/description/




import java.io.*;
import java.util.*;


class BitonicParts {
    public int compareSums(int[] nums) {
        long ascSum = nums[0], descSum = 0;
        int idx = Integer.MAX_VALUE;
        for(int i=1; i<nums.length; i++) {
            if(nums[i-1] < nums[i]) {
                ascSum+=nums[i];
            } else {
                idx = Math.min(idx, i);
                descSum+=nums[i];
            }
        }
        descSum+=nums[idx-1];
        if(ascSum > descSum) {
            return 0;
        }
        if(ascSum < descSum) {
            return 1;
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        BitonicParts parts = new BitonicParts();
        int[] nums = {1,3,2,1};
        System.out.println(parts.compareSums(nums));
        
        int[] nums1 = {2,4,5,2};
        System.out.println(parts.compareSums(nums1));
        
        int[] nums2 = {1,2,4,3};
        System.out.println(parts.compareSums(nums2));
        
        int[] nums3 = {30494606,875031872,850559628,844602130};
        System.out.println(parts.compareSums(nums3));
    }
}