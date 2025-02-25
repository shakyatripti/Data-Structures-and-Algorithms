//Problem: https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/description/

import java.io.*;
import java.util.*;

class CountSubArraysWitOddSum {
    public int countSubArrays(int[] arr) {
        long oddSum = 0, sum = 0;
        double mod = Math.pow(10,9) + 7;
        for(int i=0; i<arr.length; i++) {
            sum+=arr[i];
            if(sum%2!=0) {
                oddSum++;
            }
        }
        oddSum+=oddSum * (arr.length - oddSum);
        return (int) (oddSum % mod);
    }
}

class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int[] arr1 = {1,3,5};
        CountSubArraysWitOddSum oddSum = new CountSubArraysWitOddSum();
        System.out.println(oddSum.countSubArrays(arr));
        System.out.println(oddSum.countSubArrays(arr1));
    }
}