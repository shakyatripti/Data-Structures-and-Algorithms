//Problem: https://www.geeksforgeeks.org/problems/quick-sort/1



import java.io.*;
import java.util.*;

class QuickSort {
    public void quickSort(int[] nums) {
        sorting(nums, 0, nums.length-1);
    }
    
    public void sorting(int[] nums, int low, int high) {
        if(low >= high) {
            return;
        }
        int pivot = pivotIndex(nums, low, high);
        sorting(nums, low, pivot-1);
        sorting(nums, pivot+1, high);
    }
    
    public int pivotIndex(int[] nums, int low, int high) {
        int index = low, pivot=high;
        for(int i=low; i<high; i++) {
            if(nums[i] < nums[pivot]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
        int temp = nums[index];
        nums[index] = nums[pivot];
        nums[pivot] = temp;
        return index;
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
        QuickSort sort = new QuickSort();
        int[] nums = {3,5,9,1,4,2,7,8};
        sort.quickSort(nums);
        sort.display(nums);
        
        int[] nums2 = {-9,3,8,4,1,5,-2,11,-1};
        sort.quickSort(nums2);
        sort.display(nums2);
    }
}