//Problem: https://leetcode.com/problems/third-maximum-number/description/




import java.io.*;
import java.util.*;

class FindMaximum {
    public int thirdMax(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(!arr.contains(nums[i])) {
                arr.add(nums[i]);
            }
        }
        Collections.sort(arr);
        if(arr.size() < 3) {
            return arr.get(arr.size()-1);
        }
        return arr.get(arr.size()-3);
    }
}

class Main {
    public static void main(String[] args) {
        FindMaximum arr = new FindMaximum();
        int[] nums = {3,2,1};
        System.out.println(arr.thirdMax(nums));
        
        int[] nums1 = {1,2};
        System.out.println(arr.thirdMax(nums1));
        
        int[] nums2 = {2,2,3,1};
        System.out.println(arr.thirdMax(nums2));
    }
}