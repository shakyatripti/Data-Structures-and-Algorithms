//Problem: https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/description/





//Brute Force Solution

import java.io.*;
import java.util.*;

class AdjIncreasingSubarrays {
    public boolean hasIncreasing(List<Integer> nums, int k) {
        for(int i=0; i<=nums.size()-2*k; i++) {
            List<Integer> arr = new ArrayList<>();
            int j=0, p=0;
            for(j=i; j<i+k; j++) {
                arr.add(nums.get(j));
            }
            List<Integer> arr1 = new ArrayList<>();
            for(p=j; p<j+k; p++) {
                arr1.add(nums.get(p));
            }
            if(strictlyIncreasing(arr) && strictlyIncreasing(arr1)) {
                return true;
            }
        }
        return false;
    }

    public boolean strictlyIncreasing(List<Integer> nums1) {
        for(int i=0; i<nums1.size()-1; i++) {
            if(nums1.get(i) >= nums1.get(i+1)) {
                return false;
            }
        }
        return true;
    }
}


class Main {
    public static void main(String[] args) {
        AdjIncreasingSubarrays arr = new AdjIncreasingSubarrays();
        List<Integer> nums = new ArrayList<>(Arrays.asList(2,5,7,8,9,2,3,4,3,1));
        System.out.println(arr.hasIncreasing(nums, 3));
        
        List<Integer> nums1 = new ArrayList<>(Arrays.asList(1,2,3,4,4,4,4,5,6,7));
        System.out.println(arr.hasIncreasing(nums1, 5));
    }
}







//Better solution 


import java.io.*;
import java.util.*;

class AdjIncreasingSubarrays {
    public boolean hasIncreasing(List<Integer> nums, int k) {
        for(int i=0; i<=nums.size()-2*k; i++) {
            if(strictlyIncreasing(nums, i, k) && strictlyIncreasing(nums, i+k, k)) {
                return true;
            }
        }
        return false;
    }

    public boolean strictlyIncreasing(List<Integer> nums1, int start, int k) {
        int end = start + k - 1;
        for(int i=start; i<end; i++) {
            if(nums1.get(i) >= nums1.get(i+1)) {
                return false;
            }
        }
        return true;
    }
}


class Main {
    public static void main(String[] args) {
        AdjIncreasingSubarrays arr = new AdjIncreasingSubarrays();
        List<Integer> nums = new ArrayList<>(Arrays.asList(2,5,7,8,9,2,3,4,3,1));
        System.out.println(arr.hasIncreasing(nums, 3));
        
        List<Integer> nums1 = new ArrayList<>(Arrays.asList(1,2,3,4,4,4,4,5,6,7));
        System.out.println(arr.hasIncreasing(nums1, 5));
    }
}