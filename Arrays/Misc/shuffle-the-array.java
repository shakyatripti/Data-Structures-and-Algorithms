//Problem: https://leetcode.com/problems/shuffle-the-array/description/




import java.io.*;
import java.util.*;

class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int k=0;
        for(int i=0; i<nums.length; i+=2) {
            ans[i] = nums[k];
            k++;
        }
    
        for(int i=1; i<nums.length; i+=2) {
            ans[i] = nums[k];
            k++;
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
        ShuffleTheArray arr = new ShuffleTheArray();
        int[] nums = {2,5,1,3,4,7};
        int[] ans = arr.shuffle(nums, 3);
        arr.display(ans);
        
        int[] nums1 = {1,2,3,4,4,3,2,1};
        int[] ans1 = arr.shuffle(nums1, 4);
        arr.display(ans1);
        
        int[] nums2 = {1,1,2,2};
        int[] ans2 = arr.shuffle(nums2, 2);
        arr.display(ans2);
    }
}