//Problem: https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/description/



import java.io.*;
import java.util.*;

class PartitionArray {
    public boolean threeEqualSum(int[] arr) {
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum+=arr[i];
        }
        if(sum%3==0) {
            int val = sum/3, count = 0, total = 0;
            for(int i=0; i<arr.length; i++) {
                total+=arr[i];
                if(total==val) {
                    count++;
                    total=0;
                }
            }
            if(count>=3) {
                return true;
            }
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        PartitionArray parts = new PartitionArray();
        int[] arr = {0,2,1,-6,6,-7,9,1,2,0,1};
        System.out.println(parts.threeEqualSum(arr));
        
        int[] arr1 = {0,2,1,-6,6,7,9,-1,2,0,1};
        System.out.println(parts.threeEqualSum(arr1));
        
        int[] arr2 = {3,3,6,5,-2,2,5,1,-9,4};
        System.out.println(parts.threeEqualSum(arr2));
        
        int[] arr3 = {0,0,0,0};
        System.out.println(parts.threeEqualSum(arr3));
        
        int[] arr4 = {1,-1,1,-1};
        System.out.println(parts.threeEqualSum(arr4));
        
        int[] arr5 = {10,-10,10,-10,10,-10,10,-10};
        System.out.println(parts.threeEqualSum(arr5));
    }
}