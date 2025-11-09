//Problem: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-iii/description/





import java.io.*;
import java.util.*;

class EqualArrayElementsIII {
    public int minMoves(int[] nums) {
        int maxNum = 0, moves = 0;
        for(int i=0; i<nums.length; i++) {
            maxNum = Math.max(nums[i], maxNum);
        }

        for(int i=0; i<nums.length; i++) {
            moves+=Math.abs(nums[i]-maxNum);
        }
        return moves;
    }
}

class Main {
    public static void main(String[] args) {
        EqualArrayElementsIII arr = new EqualArrayElementsIII();
        int[] nums = {2,1,3};
        System.out.println(arr.minMoves(nums));
        
        int[] nums1 = {4,4,5};
        System.out.println(arr.minMoves(nums1));
    }
}