//Problem: https://leetcode.com/problems/removing-minimum-and-maximum-from-array/description/





import java.io.*;
import java.util.*;


class RemoveMinAndMax {
    public int minimumDeletions(int[] nums) {
        int maxVal = Integer.MIN_VALUE, minVal = Integer.MAX_VALUE, maxIndex = 0, minIndex = 0, count=0, n=nums.length;

        for(int i=0; i<n; i++) {
            if(nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }

            if(nums[i] < minVal) {
                minVal = nums[i];
                minIndex = i;
            }
        }
        int delFromBeg = Math.max(maxIndex, minIndex) + 1;
        int delFromEnd = n - Math.min(maxIndex, minIndex);
        int delFromBoth = Math.min(maxIndex, minIndex) + 1 + n - Math.max(maxIndex , minIndex);
        return Math.min(Math.min(delFromBeg, delFromEnd), delFromBoth);
    }
}

class Main {
    public static void main(String[] args) {
        RemoveMinAndMax arr = new RemoveMinAndMax();
        int[] nums = {2,10,7,5,4,1,8,6};
        System.out.println(arr.minimumDeletions(nums));
        
        int[] nums1 = {0,-4,19,1,8,-2,-3,5};
        System.out.println(arr.minimumDeletions(nums1));
        
        int[] nums2 = {101};
        System.out.println(arr.minimumDeletions(nums2));
    }
}