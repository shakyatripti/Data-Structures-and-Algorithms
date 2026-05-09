///Problem: https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/



import java.io.*;
import java.util.*;


class AvgGreaterOrEqualThreshold {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int l=0, r=k-1, n=arr.length, sum = 0, count = 0;
        for(int i=l; i<r; i++) {
            sum+=arr[i];
        }
        while(l < n && r < n) {
            sum+=arr[r];
            if((sum/k) >= threshold) {
                count++;
            }
            sum-=arr[l];
            l++;
            r++;
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        AvgGreaterOrEqualThreshold num = new AvgGreaterOrEqualThreshold();
        int[] arr = {2,2,2,2,5,5,5,8};
        System.out.println(num.numOfSubarrays(arr,3,4));
        
        int[] arr1 = {11,13,17,23,29,31,7,5,2,3};
        System.out.println(num.numOfSubarrays(arr1,3,5));
    }
}