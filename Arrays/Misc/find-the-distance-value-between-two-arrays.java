//Problem: https://leetcode.com/problems/find-the-distance-value-between-two-arrays/description/



import java.io.*;
import java.util.*;

class DistanceValue {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for(int i=0; i<arr1.length; i++) {
            boolean dist = false;
            for(int j=0; j<arr2.length; j++) {
                if(Math.abs(arr1[i]-arr2[j]) <= d) {
                    dist = true;
                    break;
                }
            }
            if(!dist) {
                count++;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        DistanceValue dist = new DistanceValue();
        int[] arr1 = {4,5,8};
        int[] arr2 = {10,9,1,8};
        System.out.println(dist.findTheDistanceValue(arr1, arr2, 2));
        
        int[] arr3 = {1,4,2,3};
        int[] arr4 = {-4,-3,6,10,20,30};
        System.out.println(dist.findTheDistanceValue(arr3, arr4, 3));
        
        int[] arr5 = {2,1,100,3};
        int[] arr6 = {-5,-2,10,-3,7};
        System.out.println(dist.findTheDistanceValue(arr5, arr6, 6));
    }
}