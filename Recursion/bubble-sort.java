//Problem: https://www.geeksforgeeks.org/problems/bubble-sort/1




import java.io.*;
import java.util.*;

class BubbleSort {
    public void bubbleSort(int[] nums) {
        sorting(nums, 0, nums.length-1);
    }
    
    public void sorting(int[] nums, int low, int high) {
        if(low > high) {
            return;
        }
        for(int i=low; i<high; i++) {
            if(nums[i] > nums[i+1]) {
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }
        sorting(nums, low, high-1);
    }
    
    public void display(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print("\n");
    }
}

class Main {
    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] nums = {3,5,9,1,4,2,7,8};
        sort.bubbleSort(nums);
        sort.display(nums);
        
        int[] nums2 = {-9,3,8,4,1,5,-2,11,-1};
        sort.bubbleSort(nums2);
        sort.display(nums2);
    }
}