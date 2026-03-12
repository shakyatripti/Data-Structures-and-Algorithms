//Problem: https://leetcode.com/problems/move-zeroes/description/



import java.io.*;
import java.util.*;


class ZeroesArray {
    public void moveZeroes(int[] nums) {
        int k=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=0) {
                nums[k] = nums[i];
                k++;
            }
        }
        while(k < nums.length) {
            nums[k]=0;
            k++;
        }
        return;
    }

    public void display(int[] nums) {
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        ZeroesArray arr = new ZeroesArray();
        int[] nums1 = {0,1,0,3,12};
        arr.moveZeroes(nums1);
        arr.display(nums1);

        int[] nums2 = {0};
        arr.moveZeroes(nums2);
        arr.display(nums2);
    }
}