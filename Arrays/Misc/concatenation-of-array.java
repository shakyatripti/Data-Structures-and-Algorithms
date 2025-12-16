//Problem: https://leetcode.com/problems/concatenation-of-array/description/




import java.io.*;
import java.util.*;

class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2*nums.length];
        int k=0;
        for(int i=0; i<2; i++) {
            for(int j=0; j<nums.length; j++) {
                ans[k] = nums[j];
                k++;
            }
        }
        return ans;
    }
    
    public void display(int[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        ConcatenationOfArray arr = new ConcatenationOfArray();
        int[] nums = {1,2,1};
        int[] ans = arr.getConcatenation(nums);
        arr.display(ans);
        
        int[] nums1 = {1,3,2,1};
        int[] ans1 = arr.getConcatenation(nums1);
        arr.display(ans1);
    }
}