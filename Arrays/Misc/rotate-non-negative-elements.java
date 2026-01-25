//Problem: https://leetcode.com/problems/rotate-non-negative-elements/description/





import java.io.*;
import java.util.*;

class NonNegativeElements {
    public int[] rotate(int[] nums, int k) {
        int n=nums.length, t=0, r=0;
        int[] ans = new int[n];
        for(int i=0; i<nums.length; i++) {
            if(nums[i] < 0) {
                ans[i] = nums[i];
                t++;
            }
        }
        if(t==nums.length) {
            return nums;
        }
        int[] pos = new int[n-t];
        for(int i=0; i<nums.length; i++) {
            if(nums[i] >=0) {
                pos[r] = nums[i];
                r++;
            }
        }
        k=k%pos.length;
        reverse(pos, 0, k-1);
        reverse(pos, k, pos.length-1);
        reverse(pos, 0, pos.length-1);
        t=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] >= 0) {
                ans[i] = pos[t];
                t++;
            }
        }
        return ans;
    }

    public void reverse(int[] arr, int start, int end) {
        while(start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
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
        NonNegativeElements arr = new NonNegativeElements();
        int[] nums = {1,-2,3,-4};
        int[] ans = arr.rotate(nums, 3);
        arr.display(ans);
        
        int[] nums1 = {-3,-2,7};
        int[] ans1 = arr.rotate(nums1, 1);
        arr.display(ans1);
        
        int[] nums2 = {5,4,-9,6};
        int[] ans2 = arr.rotate(nums2, 2);
        arr.display(ans2);
        
        int[] nums3 = {-6,-2};
        int[] ans3 = arr.rotate(nums3, 18866);
        arr.display(ans3);
    }
}