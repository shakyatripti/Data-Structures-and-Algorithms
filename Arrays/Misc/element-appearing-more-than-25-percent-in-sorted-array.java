//Problem: https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/description/






import java.io.*;
import java.util.*;

class SpecialInteger {
    public int findInSorted(int[] arr) {
        int maxFreq=0, ans=0;
        int[] freq = new int[100001];
        for(int i=0; i<arr.length; i++) {
            freq[arr[i]]++;
        }

        for(int i=0; i<arr.length; i++) {
            if(freq[arr[i]] > maxFreq) {
                maxFreq = freq[arr[i]];
                ans = arr[i];
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        SpecialInteger ans = new SpecialInteger();
        int[] arr = {1,2,2,6,6,6,6,7,10};
        System.out.println(ans.findInSorted(arr));
        
        int[] arr1 = {1,1};
        System.out.println(ans.findInSorted(arr1));
        
        int[] arr2 = {5668,5668,5668,5668,22011};
        System.out.println(ans.findInSorted(arr2));
    }
}