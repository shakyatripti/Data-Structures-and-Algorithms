//Problem: https://leetcode.com/problems/array-partition/description/




import java.io.*;
import java.util.*;

class ArrayPartition {
    public int partition(int[] nums) {
        int sum=0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i+=2) {
            sum+=nums[i];
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayPartition arr = new ArrayPartition();
        int[] nums = {1,4,3,2};
        System.out.println(arr.partition(nums));
        
        int[] nums1 =  {6,2,6,5,1,2};
        System.out.println(arr.partition(nums1));
    }
}