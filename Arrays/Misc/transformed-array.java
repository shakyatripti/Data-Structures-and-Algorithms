//Problem: https://leetcode.com/problems/transformed-array/description/



import java.io.*;
import java.util.*;

class TransformedArray {
    public int[] construct(int[] nums) {
        int n=nums.length;
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            if(nums[i] > 0) {
                int val = (i + nums[i])%n;
                result[i] = nums[val];
            } else {
                int val = ((i + nums[i]) % n + n) % n;
                result[i] = nums[val];
            }
        }
        return result;
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
        TransformedArray arr = new TransformedArray();
        int[] nums = {3,-2,1,1};
        int[] ans = arr.construct(nums);
        arr.display(ans);
        
        int[] nums1 = {-1,4,-1};
        int[] ans1 = arr.construct(nums1);
        arr.display(ans1);
    }
}