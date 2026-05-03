//Problem: https://leetcode.com/problems/count-indices-with-opposite-parity/description/




import java.io.*;
import java.util.*;

class OppositeParity {
    public int[] countIndices(int[] nums) {
        int n=nums.length;
        boolean isEven = true;
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            int count = 0;
            if(nums[i]%2==0) {
                isEven = true;
            } else {
                isEven = false;
            }
            for(int j=i+1; j<n; j++) {
                if(nums[j]%2==0 && !isEven) {
                    count++;
                }
                if(nums[j]%2!=0 && isEven) {
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
        OppositeParity arr = new OppositeParity();
        int[] nums = {1,2,3,4};
        int[] ans = arr.countIndices(nums);
        arr.display(ans);
        
        int[] nums1 = {1};
        int[] ans1 = arr.countIndices(nums1);
        arr.display(ans1);
    }
}