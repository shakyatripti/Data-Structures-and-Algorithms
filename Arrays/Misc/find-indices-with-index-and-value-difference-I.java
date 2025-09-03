//Problem: https://leetcode.com/problems/find-indices-with-index-and-value-difference-i/description/





import java.io.*;
import java.util.*;

class IndexValueDifference {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] ans = {-1,-1};
        for(int i=0; i<nums.length; i++) {
            for(int j=i; j<nums.length; j++) {
                int val1 = Math.abs(i-j);
                int val2 = Math.abs(nums[i]-nums[j]);
                if(val1 >=indexDifference && val2 >=valueDifference) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        IndexValueDifference array = new IndexValueDifference();
        int[] nums = {5,1,4,1};
        int[] ans = array.findIndices(nums, 2, 4);
        System.out.println(ans[0] + " " + ans[1]);
        
        int[] nums1 = {2,1};
        int[] ans1 = array.findIndices(nums1, 0, 0);
        System.out.println(ans1[0] + " " + ans1[1]);
        
        int[] nums2 = {1,2,3};
        int[] ans2 = array.findIndices(nums2, 2, 4);
        System.out.println(ans2[0] + " " + ans2[1]);
    }
}