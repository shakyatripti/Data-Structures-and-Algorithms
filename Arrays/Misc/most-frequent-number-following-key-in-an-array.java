//Problem: https://leetcode.com/problems/most-frequent-number-following-key-in-an-array/description/




import java.io.*;
import java.util.*;

class NumberFollowingKey {
    public int mostFrequent(int[] nums, int key) {
        int count = 0, ans = 0;
        int[] freq = new int[1001];
        for(int i=1; i<nums.length; i++) {
            if(nums[i-1]==key) {
                freq[nums[i]]++;
            }
        }

        for(int i=0; i<1001; i++) {
            if(freq[i] > 0) {
                if(freq[i]==count) {
                    ans = Math.max(i, ans);
                }
                if(freq[i] > count) {
                    count = freq[i];
                    ans = i;
                }
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        NumberFollowingKey arr = new NumberFollowingKey();
        int[] nums = {1,100,200,1,100};
        System.out.println(arr.mostFrequent(nums, 1));
        
        int[] nums1 = {2,2,2,2,3};
        System.out.println(arr.mostFrequent(nums1, 2));
    }
}