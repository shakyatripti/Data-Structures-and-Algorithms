//Problem: https://leetcode.com/problems/sort-array-by-parity/description/





import java.io.*;
import java.util.*;

class SortArray {
    public int[] byParity(int[] nums) {
        int[] ans = new int[nums.length];
        int m=0, n=nums.length-1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]%2==0) {
                ans[m]=nums[i];
                m++;
            } else {
                ans[n]=nums[i];
                n--;
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
        SortArray arr = new SortArray();
        int[] nums = {3,1,2,4};
        int[] ans = arr.byParity(nums);
        arr.display(ans);
        
        int[] nums1 = {0};
        int[] ans1 = arr.byParity(nums1);
        arr.display(ans1);
    }
}