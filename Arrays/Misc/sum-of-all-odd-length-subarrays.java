//Problem: https://leetcode.com/problems/sum-of-all-odd-length-subarrays/description/




import java.io.*;
import java.util.*;


class OddLengthSubarrays {
    public int findSum(int[] arr) {
        int n=arr.length, total = 0;
        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=i; j<n; j++) {
                int size = j - i + 1;
                sum+=arr[j];
                if(size%2!=0) {
                    total+=sum;
                }
            }
        }
        return total;
    }
}

class Main {
    public static void main(String[] args) {
        OddLengthSubarrays subarr = new OddLengthSubarrays();
        int[] arr = {1,4,2,5,3};
        System.out.println(subarr.findSum(arr));
        
        int[] arr1 = {1,2};
        System.out.println(subarr.findSum(arr1));
        
        int[] arr2 = {10,11,12};
        System.out.println(subarr.findSum(arr2));
    }
}