//Problem: https://leetcode.com/problems/count-hills-and-valleys-in-an-array/description/




import java.io.*;
import java.util.*;

class HillsAndValleys {
    public int countHillValley(int[] nums) {
        int i=1, left = 0, right = 2, ans=0;
        while(left < nums.length && right < nums.length) {
            if((nums[i] > nums[left] && nums[i] > nums[right]) || (nums[i] < nums[left] && nums[i] < nums[right])) {
                ans++;
                left = i;
            } else if(nums[i]==nums[left]) {
                left = i;
            }
            i++;
            right++;
        }
        return ans;
    }
}


class Main {
    public static void main(String[] args) {
        HillsAndValleys obj = new HillsAndValleys();
        int[] nums = {2,4,1,1,6,5};
        System.out.println(obj.countHillValley(nums));
        
        int[] nums1 = {6,6,5,5,4,1};
        System.out.println(obj.countHillValley(nums1));
        
        int[] nums2 = {1,4,5};
        System.out.println(obj.countHillValley(nums2));
        
        int[] nums3 = {3,3,3,5,5,4,9};
        System.out.println(obj.countHillValley(nums3));
        
        int[] nums4 = {1,1,1,1,1,2,1};
        System.out.println(obj.countHillValley(nums4));
    }
}