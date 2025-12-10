//Problem: https://leetcode.com/problems/relative-sort-array/description/




import java.io.*;
import java.util.*;

class RelativeSortArray {
    public int[] sortBy(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        int[] freq = new int[1001];
        int k=0;
        for(int i=0; i<arr1.length; i++) {
            freq[arr1[i]]++;
        }

        for(int i=0; i<arr2.length; i++) {
            int val = freq[arr2[i]];
            for(int j=0; j<val; j++) {
                ans[k] = arr2[i];
                freq[arr2[i]]--;
                k++;
            }
        }

        for(int i=0; i<1001; i++) {
            for(int j=0; j<freq[i]; j++) {
                ans[k] = i;
                k++;
            }
        }
        return ans;
    }
    
    public void display(int[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        RelativeSortArray array = new RelativeSortArray();
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] ans = array.sortBy(arr1, arr2);
        array.display(ans);
        
        int[] arr3 = {28,6,22,8,44,17};
        int[] arr4 = {22,28,8,6};
        int[] ans1 = array.sortBy(arr3, arr4);
        array.display(ans1);
    }
}