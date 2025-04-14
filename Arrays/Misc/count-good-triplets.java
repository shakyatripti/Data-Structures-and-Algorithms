//Problem: https://leetcode.com/problems/count-good-triplets/description/



import java.io.*;
import java.util.*;

class CountGoodTriplets {
    public int countTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for(int i=0; i<arr.length-2; i++) {
            for(int j=i+1; j<arr.length-1; j++) {
                int diff = Math.abs(arr[i] - arr[j]);
                if(diff<=a) {
                    for(int k=j+1; k<arr.length; k++) {
                        int diff2 = Math.abs(arr[j] - arr[k]);
                        int diff3 = Math.abs(arr[k] - arr[i]);
                        if(diff2<=b && diff3<=c) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        CountGoodTriplets goodTriplets = new CountGoodTriplets();
        int[] nums = {3,0,1,1,9,7};
        System.out.println(goodTriplets.countTriplets(nums, 7, 2, 3));
        
        int[] nums2 = {1,1,2,2,3};
        System.out.println(goodTriplets.countTriplets(nums2, 0, 0, 1));
    }
}