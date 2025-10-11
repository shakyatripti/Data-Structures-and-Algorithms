//Problem: https://leetcode.com/problems/ant-on-the-boundary/description/




import java.util.*;
import java.io.*;


class AntOnTheBoundary {
    public int returnToBoundaryCount(int[] nums) {
        int count = 0, steps = 0;
        for(int i=0; i<nums.length; i++) {
            steps+=nums[i];
            if(steps==0) {
                count++;
            }
        }
        return count;
    }
}


class Main {
    public static void main(String[] args) {
        AntOnTheBoundary ants = new AntOnTheBoundary();
        int[] nums = {2,3,-5};
        System.out.println(ants.returnToBoundaryCount(nums));
        
        int[] nums1 = {3,2,-3,-4};
        System.out.println(ants.returnToBoundaryCount(nums1));
    }
}