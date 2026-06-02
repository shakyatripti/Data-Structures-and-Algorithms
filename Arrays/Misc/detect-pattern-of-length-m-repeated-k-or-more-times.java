//Problem: https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/description/




import java.io.*;
import java.util.*;


class DetectPattern {
    public boolean isExisting(int[] arr, int m, int k) {
        for(int p=0; p<=arr.length-m; p++) {
            String prev="";
            int count = 1;
            for(int i=p; i<=arr.length-m; i+=m) {
                String curr = "";
                for(int j=i; j<i+m; j++) {
                    curr+=arr[j] + "-";
                }
                if(prev.equals(curr)) {
                    count++;
                } else {
                    count = 1;
                }
                
                if(count>=k) {
                    return true;
                }
                prev=curr;
            }
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        DetectPattern pattern = new DetectPattern();
        int[] arr = {1,2,4,4,4,4};
        System.out.println(pattern.isExisting(arr, 1, 3));
        
        int[] arr1 = {1,2,1,2,1,1,1,3};
        System.out.println(pattern.isExisting(arr1, 2, 2));
        
        int[] arr2 = {1,2,1,2,1,3};
        System.out.println(pattern.isExisting(arr2, 2, 3));
        
        int[] arr3 = {1,2,3,1,2};
        System.out.println(pattern.isExisting(arr3, 2, 2));
        
        int[] arr4 = {33, 3, 33, 33, 3, 33, 3};
        System.out.println(pattern.isExisting(arr4, 2, 3));
    }
}