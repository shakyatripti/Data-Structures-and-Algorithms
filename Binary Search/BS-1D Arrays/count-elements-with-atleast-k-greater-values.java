//Problem: https://leetcode.com/problems/count-elements-with-at-least-k-greater-values/description/




import java.io.*;
import java.util.*;

class GreaterValues {
    public int countElements(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0, count=0;
        while(i < nums.length) {
            int lastPos = upperBound(nums[i], nums);
            int greaterEle = nums.length - lastPos - 1;
            if(greaterEle >= k) {
                count+=lastPos-i+1;
            }
            i = lastPos + 1;
        }
        return count;
    }

    public int upperBound(int n, int[] nums) {
        int l=0, r=nums.length-1, ans=0;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(nums[mid] > n) {
                r=mid-1;
            } else {
                ans = mid;
                l=mid+1;
            }

        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        GreaterValues arr = new GreaterValues();
        int[] nums = {3,1,2,3};
        System.out.println(arr.countElements(nums, 1));
        
        int[] nums1 = {5,5,5,5};
        System.out.println(arr.countElements(nums1, 2));
        
        int[] nums2 = {3,1,2,};
        System.out.println(arr.countElements(nums2, 1));
    }
}