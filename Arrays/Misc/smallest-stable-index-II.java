//Problem: https://leetcode.com/problems/smallest-stable-index-ii/description/




import java.io.*;
import java.util.*;


class StableIndexII  {
    public int firstSmallest(int[] nums, int k) {
        int n=nums.length;
        int[] largest = new int[n];
        int[] smallest = new int[n];
        largest[0] = nums[0];
        smallest[n-1] = nums[n-1];
        for(int i=1; i<n; i++) {
            largest[i] = Math.max(largest[i-1], nums[i]);
        }

        for(int i=n-2; i>=0; i--) {
            smallest[i] = Math.min(smallest[i+1], nums[i]);
        }

        for(int i=0; i<n; i++) {
            int ans = largest[i] - smallest[i];
            if(ans <= k) {
                return i;
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        StableIndexII index = new StableIndexII();
        int[] nums = {5,0,1,4};
        System.out.println(index.firstSmallest(nums, 3));
        
        int[] nums1 = {3,2,1};
        System.out.println(index.firstSmallest(nums1, 1));
        
        int[] nums2 = {0};
        System.out.println(index.firstSmallest(nums2, 0));
    }
}