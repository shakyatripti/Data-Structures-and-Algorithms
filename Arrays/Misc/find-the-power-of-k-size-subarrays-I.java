//Problem: https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/description/



import java.io.*;
import java.util.*;


class KSizeSubarraysI {
    public int[] findPower(int[] nums, int k) {
        int n=nums.length;
        int[] ans = new int[n-k+1];
        Arrays.fill(ans, -1);
        for(int i=0; i<=n-k; i++) {
            int maxNum = nums[i], flag = 0;
            for(int j=i; j<i+k-1; j++) {
                if((nums[j+1] - nums[j])!=1) {
                    flag = -1;
                    break;
                }
                maxNum = Math.max(nums[j+1], maxNum);
            }
            if(flag==0) {
                ans[i] = maxNum;
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
        KSizeSubarraysI subarr = new KSizeSubarraysI();
        int[] nums = {1,2,3,4,3,2,5};
        int[] ans = subarr.findPower(nums, 3);
        subarr.display(ans);
        
        int[] nums1 = {2,2,2,2,2};
        int[] ans1 = subarr.findPower(nums1, 4);
        subarr.display(ans1);
        
        int[] nums2 = {3,2,3,2,3,2};
        int[] ans2 = subarr.findPower(nums2, 2);
        subarr.display(ans2);
    }
}