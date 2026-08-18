//Problem: https://leetcode.com/problems/sort-array-by-parity-ii/description/





import java.io.*;
import java.util.*;

class ParityII {
    public int[] sortArray(int[] nums) {
        int even=0, odd=1, n=nums.length;
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            if(nums[i]%2==0) {
                ans[even] = nums[i];
                even+=2;
            } else {
                ans[odd] = nums[i];
                odd+=2;
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
        ParityII arr = new ParityII();
        int[] nums = {4,2,5,7};
        int[] ans = arr.sortArray(nums);
        arr.display(ans);
        
        int[] nums1 = {2,3};
        int[] ans1 = arr.sortArray(nums1);
        arr.display(ans1);
    }
}