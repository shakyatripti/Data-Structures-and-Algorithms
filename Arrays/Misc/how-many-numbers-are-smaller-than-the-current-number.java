//Problem: https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/





import java.io.*;
import java.util.*;

class SmallerNumbers {
    public int[] countNumbers(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            int count = 0;
            for(int j=0; j<nums.length; j++) {
                if(nums[i] > nums[j]) {
                    count++;
                }
            }
            ans[i] = count;
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
        SmallerNumbers arr = new SmallerNumbers();
        int[] nums = {8,1,2,2,3};
        int[] ans = arr.countNumbers(nums);
        arr.display(ans);
        
        int[] nums1 = {6,5,4,8};
        int[] ans1 = arr.countNumbers(nums1);
        arr.display(ans1);
        
        int[] nums2 = {7,7,7,7};
        int[] ans2 = arr.countNumbers(nums2);
        arr.display(ans2);
    }
}