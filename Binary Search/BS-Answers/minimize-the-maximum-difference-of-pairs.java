//Problem: https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/description/


/*Problem Statement: We need to find p pairs such that the maximum difference between those pairs is as less as possible. 
    Note that for a pair of elements at the index i and j, the difference of this pair is |nums[i] - nums[j]|, where |x| represents the absolute value of x.

    Ex: [1,9,2,5,3] and p=2, we will pick pairs (1,2) & (3,5) because max difference between them is minimum (Math.max(1,2) = 2). 
    If we have picked (1,9) & (2,3) as pairs then max difference will be 8 (Math.max(8,1)). Thus we cannot choose (1,9) & (2,3) as max difference is not minimum.

    Sort the array and use binary search to check if given mid is occurring as difference in how many pairs. Max difference possible will be 
    last element(largest) - first element(smallest). Iterate over array to find how many pairs are there whose value is equal to aur less than mid.
    If no. of pairs >= p then we will shrink our search from right. 
*/



import java.io.*;
import java.util.*;

class MinMaxDifference {
    public int minimizeDiff(int[] nums, int p) {
        Arrays.sort(nums);
        int l=0, r=nums[nums.length-1]-nums[0], result=0;
        while(l<=r) {
            int mid  = l + (r-l)/2;
            if(isPossible(mid, nums, p)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
    
    public boolean isPossible(int mid, int[] nums, int p) {
        int pairs = 0, i=0;
        while(i < nums.length-1) {
            if(Math.abs(nums[i+1]-nums[i]) <=mid) {
                pairs++;
                i+=2;
            } else {
                i++;
            }
        }
        return pairs>=p;
    }
}

class Main {
    public static void main(String[] args) {
        MinMaxDifference diff = new MinMaxDifference();
        int[] nums = {10,1,2,7,1,3};
        System.out.println(diff.minimizeDiff(nums, 2));
        
        int[] nums2 = {4,2,1,2};
        System.out.println(diff.minimizeDiff(nums2, 1));
        
        int[] nums3 = {9,7,3,11};
        System.out.println(diff.minimizeDiff(nums3, 2));
    }
}