//Problem: https://leetcode.com/problems/minimum-swaps-to-move-zeros-to-end/description/




import java.io.*;
import java.util.*;

class MoveZeroesToEnd {
    public int minimumSwaps(int[] nums) {
        int totalZeroes = 0, n = nums.length;
        for(int i=0; i<n; i++) {
            if(nums[i]==0) {
                totalZeroes++;
            }
        }
        int end = n - totalZeroes;
        for(int i=n-1; i>=end; i--) {
            if(nums[i]==0) {
                totalZeroes--;
            }
        }
        return totalZeroes;
    }
}

class Main {
    public static void main(String[] args) {
        MoveZeroesToEnd zeroes = new MoveZeroesToEnd();
        int[] nums = {0,1,0,3,12};
        System.out.println(zeroes.minimumSwaps(nums));
        
        int[] nums1 = {0,1,0,2};
        System.out.println(zeroes.minimumSwaps(nums1));
        
        int[] nums2 = {1,2,0};
        System.out.println(zeroes.minimumSwaps(nums2));
        
        int[] nums3 = {0,0};
        System.out.println(zeroes.minimumSwaps(nums3));
    }
}