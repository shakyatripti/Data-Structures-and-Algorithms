//Problem: https://leetcode.com/problems/check-if-n-and-its-double-exist/description/



import java.io.*;
import java.util.*;

class CheckDoubleExists {
    public boolean checkIfExists(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                if(i!=j && arr[i]==2*arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        CheckDoubleExists arr = new CheckDoubleExists();
        int[] nums = {10,2,5,3};
        System.out.println(arr.checkIfExists(nums));
        
        int[] nums2 = {0,-2,2};
        System.out.println(arr.checkIfExists(nums2));
    }
}