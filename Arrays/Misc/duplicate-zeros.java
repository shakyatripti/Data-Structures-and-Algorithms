//Problem: https://leetcode.com/problems/duplicate-zeros/description/



import java.io.*;
import java.util.*;

class DuplicateZeros {
    public void shift(int[] arr) {
        ArrayList<Integer> num = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==0) {
                num.add(0);
                num.add(0);
            } else {
                num.add(arr[i]);
            }
        }

        for(int i=0; i<arr.length; i++) {
            arr[i] = num.get(i);
        }
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
        DuplicateZeros num = new DuplicateZeros();
        int[] arr = {1,0,2,3,0,4,5,0};
        num.shift(arr);
        num.display(arr);
        
        int[] arr1 = {1,2,3};
        num.shift(arr1);
        num.display(arr1);
    }
}