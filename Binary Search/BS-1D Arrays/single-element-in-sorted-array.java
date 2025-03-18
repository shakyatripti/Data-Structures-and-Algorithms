//Problem: https://leetcode.com/problems/single-element-in-a-sorted-array/description/


//Brute force: Using linear search
import java.io.*;
import java.util.*;

class SingleElement {
    public int findSingle(int[] nums) {
        int l=0, r=nums.length-1;
        while(l<=r) {
            if(nums[l]!=nums[l+1]) {
                return nums[l];
            }
            if(nums[r]!=nums[r-1]) {
                return nums[r];
            }
            l+=2;
            r-=2;
        }
        return 0;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,5,5};
        SingleElement arr = new SingleElement();
        System.out.println(arr.findSingle(nums));
        
        int[] nums2 = {3,3,6,6,7,7,10,10,11,19,19};
        System.out.println(arr.findSingle(nums2));
        
    }
}


//Optimal solution: Using Binary Search
import java.io.*;
import java.util.*;

class SingleElement {
    public int findSingle(int[] nums) {
        int l=0, r=nums.length-1;
        boolean isEven = false;
        while(l<r) {
            int mid = (l+r)/2;
            if((r-mid)%2==0) {
                isEven = true;
            } else {
                isEven = false;
            }
            
            if(nums[mid]!=nums[mid+1]) {
                if(isEven) {
                    r=mid;
                } else {
                    l=mid+1;
                }
            } else {
                if(isEven) {
                    l = mid + 2;
                } else {
                    r=mid-1;
                }
            }
        }
        return nums[l];
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,5,5};
        SingleElement arr = new SingleElement();
        System.out.println(arr.findSingle(nums));
        
        int[] nums2 = {3,3,6,6,7,7,10,10,11,19,19,20,20};
        System.out.println(arr.findSingle(nums2));
        
        int[] nums3 = {1};
        System.out.println(arr.findSingle(nums3));
        
    }
}