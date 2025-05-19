//Problem: https://leetcode.com/problems/type-of-triangle/description/



import java.io.*;
import java.util.*;


class TypeOfTriangle {
    public String triangleType(int[] nums) {
        if(nums[0]==nums[1] && nums[1]==nums[2]) {
            return "equilateral";
        }

        if((nums[1] + nums[2] <= nums[0]) || (nums[1] + nums[0] <= nums[2]) || (nums[2] + nums[0] <= nums[1])) {
            return "none";
        }
        if(nums[0]==nums[1] || nums[1]==nums[2] || nums[2]==nums[0]) {
            return "isosceles";
        } 
        return "scalene";
    }
}

class Main {
    public static void main(String[] args) {
        TypeOfTriangle triangle = new TypeOfTriangle();
        int[] nums = {3,3,3};
        System.out.println(triangle.triangleType(nums));
        
        int[] nums1 = {1,2,3};
        System.out.println(triangle.triangleType(nums1));
        
        int[] nums2 = {3,4,5};
        System.out.println(triangle.triangleType(nums2));
        
        int[] nums3 = {5,5,2};
        System.out.println(triangle.triangleType(nums3));
    }
}