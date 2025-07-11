//Problem: https://leetcode.com/problems/range-sum-query-immutable/description/



import java.io.*;
import java.util.*;

class NumArray {
    int[] arr;
    public NumArray(int[] nums) {
        arr = nums;
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i=left; i<=right; i++) {
           sum+=arr[i];
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {-2,0,3,-5,2,-1};
        NumArray arr = new NumArray(nums);
        System.out.println(arr.sumRange(0,2));
        System.out.println(arr.sumRange(2,5));
        System.out.println(arr.sumRange(0,5));
    }
}