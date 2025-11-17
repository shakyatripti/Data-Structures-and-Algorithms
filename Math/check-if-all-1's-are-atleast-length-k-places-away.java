//Problem: https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/description/





import java.io.*;
import java.util.*;


class KPlacesAway {
    public boolean kLengthApart(int[] nums, int k) {
        int prev = -1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==1) {
                if(prev!=-1 && i-prev-1 < k) {
                    return false;
                }
                prev=i;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        KPlacesAway ones = new KPlacesAway();
        int[] nums = {1,0,0,0,1,0,0,1};
        System.out.println(ones.kLengthApart(nums, 2));
        
        int[] nums1 = {1,0,0,1,0,1};
        System.out.println(ones.kLengthApart(nums1, 2));
        
        int[] nums2 = {1,1,1,1,1};
        System.out.println(ones.kLengthApart(nums2, 0));
    }
}