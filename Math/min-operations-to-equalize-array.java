//Problem: https://leetcode.com/problems/minimum-operations-to-equalize-array/description/





import java.io.*;
import java.util.*;

class EqualizeArray {
    public int minOperations(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            st.add(nums[i]);
        } 
        if(st.size()==1) {
            return 0;
        }
        return 1;
    }
}

class Main {
    public static void main(String[] args) {
        EqualizeArray arr = new EqualizeArray();
        int[] nums = {1,2};
        System.out.println(arr.minOperations(nums));
        
        int[] nums1 = {5,5,5};
        System.out.println(arr.minOperations(nums1));
        
        int[] nums2 = {3,3,2,1,6,11,2};
        System.out.println(arr.minOperations(nums2));
    }
}