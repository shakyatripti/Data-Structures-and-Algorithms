//Problem: https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1


import java.io.*;
import java.util.*;

class CountOccurrences {
    public int countFreq(int[] nums, int target) {
        int l=0, r=nums.length-1, first=-1, last=-1;
        while(l<=r) {
            int mid = (l+r)/2;
            if(nums[mid]==target) {
                first = mid;
                r = mid - 1;
            } else if(nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        l=0; r=nums.length-1;
        while(l<=r) {
            int mid = (l+r)/2;
            if(nums[mid]==target) {
                last = mid;
                l = mid + 1;
            } else if(nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        if(last==-1 && first==-1) {
            return -1;
        }
        return last-first+1;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,4,5};
        CountOccurrences arr = new CountOccurrences();
        System.out.println(arr.countFreq(nums,2));
        System.out.println(arr.countFreq(nums,3));
        System.out.println(arr.countFreq(nums,4));
    }
}