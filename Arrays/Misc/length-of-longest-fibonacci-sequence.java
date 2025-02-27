//Problem: https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/description/


import java.util.*;
import java.io.*;

class LongestFibonacciSeq {
    public int longestSequence(int[] arr) {
        int len = Integer.MIN_VALUE;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            mp.put(arr[i], i);
        }
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                int firstNum = arr[i];
                int secondNum = arr[j];
                int currLen = 2;
                while(mp.containsKey(firstNum + secondNum)) {
                    currLen++;
                    len = Math.max(currLen, len);
                    int sum = firstNum + secondNum;
                    firstNum = secondNum;
                    secondNum = sum;
                }
            }
        }
        return len==Integer.MIN_VALUE ? 0 : len;
    }
}

class Main {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,8,10,11,14,16};
        LongestFibonacciSeq seq = new LongestFibonacciSeq();
        System.out.println(seq.longestSequence(arr));
        int[] arr2 = {1,3,7,11,12,14,18};
        System.out.println(seq.longestSequence(arr2));
    }
}