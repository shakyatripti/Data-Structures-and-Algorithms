//Problem: https://leetcode.com/problems/find-common-elements-between-two-arrays/description/




import java.io.*;
import java.util.*;


class CommonElements {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] freq1 = new int[101];
        int[] freq2 = new int[101];
        for(int i=0; i<nums1.length; i++) {
            freq1[nums1[i]]++;
        }
        for(int i=0; i<nums2.length; i++) {
            freq2[nums2[i]]++;
        }
        int ans1=0, ans2=0;
        for(int i=1; i<=100; i++) {
            if(freq1[i]>=1) {
                ans2+=freq2[i];
            }
            if(freq2[i]>=1) {
                ans1+=freq1[i];
            }
        }
        return new int[]{ans1, ans2};
    }
}


class Main {
    public static void main (String[] args) {
        CommonElements elements = new CommonElements();
        int[] nums1 = {2,3,2};
        int[] nums2 = {1,2};
        int[] ans = elements.findIntersectionValues(nums1, nums2);
        System.out.println(ans[0] + " " + ans[1]);
        
        int[] nums3 = {4,3,2,3,1};
        int[] nums4 = {2,2,5,2,3,6};
        int[] ans1 = elements.findIntersectionValues(nums3, nums4);
        System.out.println(ans1[0] + " " + ans1[1]);
        
        int[] nums5 = {3,4,2,3};
        int[] nums6 = {1,5};
        int[] ans2 = elements.findIntersectionValues(nums5, nums6);
        System.out.println(ans2[0] + " " + ans2[1]);
    }
}