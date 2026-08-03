//Problem: https://leetcode.com/problems/count-subarrays-with-even-odd-ratio-i/description/




import java.io.*;
import java.util.*;


class EvenOddRatioI {
    public int countSubarrays(int[] nums, int a, int b) {
        int n=nums.length, ans=0;
        for(int i=0; i<n; i++) {
            int x=0, y=0;
            for(int j=i; j<n; j++) {
                if(nums[j]%2==0) {
                    x++;
                } else {
                    y++;
                }

                if(y > 0) {
                    double target = (double) a/b;
                    double source = (double) x/y;
                    if(source<=target) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        EvenOddRatioI arr = new EvenOddRatioI();
        int[] nums = {1,2,1,2};
        System.out.println(arr.countSubarrays(nums, 3, 2));
        
        int[] nums1 = {2,2,1};
        System.out.println(arr.countSubarrays(nums1, 2, 1));
        
        int[] nums2 = {2,2,2};
        System.out.println(arr.countSubarrays(nums2, 1, 1));
        
        int[] nums3 = {304,979,652,115};
        System.out.println(arr.countSubarrays(nums3, 182, 922));
    }
}