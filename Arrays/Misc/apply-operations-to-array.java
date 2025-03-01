//Problem: https://leetcode.com/problems/apply-operations-to-an-array/description/


//Brute Force solution 
import java.io.*;
import java.util.*;

class ApplyOperations {
    public int[] operationsToArray(int[] nums) {
        int l=0, r=l+1, index = 0;
        while(r < nums.length) {
            if(nums[l]==nums[r]) {
                nums[l] = nums[l]*2;
                nums[r] = 0;
            }
            l++;
            r++;
        }
        
        int[] arr = new int[nums.length];
        Arrays.fill(arr, 0);
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=0) {
                arr[index] = nums[i];
                index++;
            }
        }
        return arr;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,2,1,1,0};
        ApplyOperations arr = new ApplyOperations();
        int[] ans = arr.operationsToArray(nums);
        for(int i: ans) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        int[] nums2 = {0,1};
        int[] ans2 = arr.operationsToArray(nums2);
        for(int i: ans2) {
            System.out.print(i + " ");
        }
    }
}


//Optimal solution
import java.io.*;
import java.util.*;

class ApplyOperations {
    public int[] operationsToArray(int[] nums) {
        int i=0, index = 0;
        int[] arr = new int[nums.length];
        Arrays.fill(arr, 0);
        
        for(i=0; i<nums.length-1; i++) {
            if(nums[i]!=0) {
                if(nums[i]==nums[i+1]) {
                    arr[index] = nums[i]*2;
                    i++;
                } else {
                    arr[index] = nums[i];
                }
                index++;
            }
        }
        
        if(i==nums.length-1) {
            arr[index] = nums[i];
        }
        return arr;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,2,1,1,0};
        ApplyOperations arr = new ApplyOperations();
        int[] ans = arr.operationsToArray(nums);
        for(int i: ans) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        int[] nums2 = {0,1};
        int[] ans2 = arr.operationsToArray(nums2);
        for(int i: ans2) {
            System.out.print(i + " ");
        }
    }
}