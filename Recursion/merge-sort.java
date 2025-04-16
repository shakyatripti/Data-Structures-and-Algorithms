//Problem: https://www.geeksforgeeks.org/problems/merge-sort/1




import java.io.*;
import java.util.*;

class MergeSort {
    public void mergeSort(int[] nums) {
        split(nums, 0, nums.length-1);
    }
    
    public void split(int[] nums, int l, int r) {
        if(l==r) {
            return;
        }
        int mid = l + (r-l)/2;
        split(nums, l, mid); //Trust: It will return sorted leftSplit
        split(nums, mid+1, r);// Trust: It will return sorted rightSplit
        merge(nums, l, mid, r);// Simply merge the sorted left and right split.
    }
    
    public void merge(int[] nums, int l, int mid, int r) {
        int i=0, j=0, k=l, n=mid-l+1, m=r-mid;
        int[] leftSide = new int[n];
        int[] rightSide = new int[m];
        for(i=0; i<n; i++) {
            leftSide[i] = nums[k];
            k++;
        }
        for(j=0; j<m; j++) {
            rightSide[j] = nums[k];
            k++;
        }
        i=0; j=0; k=l;
        while(i < n && j < m) {
            if(leftSide[i] > rightSide[j]) {
                nums[k] = rightSide[j];
                j++;
            } else {
                nums[k] = leftSide[i];
                i++;
            }
            k++;
        }
        
        while(i < n) {
            nums[k] = leftSide[i];
            i++;
            k++;
        }
        
        while(j < m) {
            nums[k] = rightSide[j];
            j++;
            k++;
        }
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
        MergeSort sort = new MergeSort();
        int[] nums = {5,2,3,1,4};
        sort.mergeSort(nums);
        sort.display(nums);
        
        int[] nums2 = {-9,2,1,-6,5};
        sort.mergeSort(nums2);
        sort.display(nums2);
    }
}