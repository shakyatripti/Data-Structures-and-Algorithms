//Problem: https://www.geeksforgeeks.org/problems/insertion-sort/1




import java.io.*;
import java.util.*;

class InsertionSort {
    public void insertionSort(int[] arr) {
        sorting(arr, 1);
    }
    
    public void sorting(int[] arr, int i) {
        if(i==arr.length) {
            return;
        }
        int j=i;
        while(j > 0 && j < arr.length && arr[j] < arr[j-1]) {
            int temp = arr[j];
            arr[j] = arr[j-1];
            arr[j-1] = temp;
            j--;
        }
        
        sorting(arr, i+1);
    }
    
    public void display(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] +  " ");
        }
        System.out.print("\n");
    }
}


class Main {
    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        int[] nums = {3,8,5,2,1,4,7};
        sort.insertionSort(nums);
        sort.display(nums);
        
        int[] nums1 = {-9,4,2,5,1,-2,3};
        sort.insertionSort(nums1);
        sort.display(nums1);
    }
}