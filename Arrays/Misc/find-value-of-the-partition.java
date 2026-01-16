//Problem: https://leetcode.com/problems/find-the-value-of-the-partition/description/





import java.io.*;
import java.util.*;


class ParitionValue {
    public int findValue(int[] nums) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for(int i=1; i<nums.length; i++) {
            int diff = nums[i] - nums[i-1];
            ans = Math.min(ans, diff);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        ParitionValue arr = new ParitionValue();
        int[] nums = {1,3,2,4};
        System.out.println(arr.findValue(nums));
        
        int[] nums1 = {100,1,10};
        System.out.println(arr.findValue(nums1));
    }
}