//Problem: https://leetcode.com/problems/largest-perimeter-triangle/description/



import java.io.*;
import java.util.*;

class LargestPerimeter {
    public int perimeterTriangle(int[] nums) {
        Arrays.sort(nums);
        for(int i=nums.length-3; i>=0; i--) {
            if(nums[i] + nums[i+1] > nums[i+2]) {
                return nums[i] + nums[i+1] + nums[i+2];
            }
        }
        return 0;
    }
}

class Main {
    public static void main(String[] args) {
        LargestPerimeter triangle = new LargestPerimeter();
        int[] nums = {2,1,2};
        System.out.println(triangle.perimeterTriangle(nums));
        
        int[] nums1 = {1,2,1,10};
        System.out.println(triangle.perimeterTriangle(nums1));
    }
}