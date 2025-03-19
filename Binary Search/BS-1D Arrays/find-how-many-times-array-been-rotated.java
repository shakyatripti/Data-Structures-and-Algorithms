//Problem: https://www.geeksforgeeks.org/problems/rotation4723/1


/*This solution is same as Find min in rotated sorted array*/
import java.io.*;
import java.util.*;

class RotationPosition {
    public int findKthRotation(int[] nums) {
        int l=0, r=nums.length-1;
        while(l<=r) {
            int mid = (l+r)/2;
            if(nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {5,4,1,2,3};
        RotationPosition arr = new RotationPosition();
        System.out.println(arr.findKthRotation(nums));
        
        int[] nums2 = {1,2,3,4,10,23};
        System.out.println(arr.findKthRotation(nums2));
    }
}