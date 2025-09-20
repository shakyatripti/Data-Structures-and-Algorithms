//Problem: https://leetcode.com/problems/decode-xored-array/description/





import java.io.*;
import java.util.*;

class DecodeXORedArray {
    public int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length + 1];
        arr[0] = first;
        for(int i=1; i<=encoded.length; i++) {
            arr[i] = encoded[i-1] ^ arr[i-1];
        }
        return arr;
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
        DecodeXORedArray arr = new DecodeXORedArray();
        int[] encoded = {1,2,3};
        int[] ans = arr.decode(encoded, 1);
        arr.display(ans);
        
        int[] encoded1 = {6,2,7,3};
        int[] ans1 = arr.decode(encoded1, 4);
        arr.display(ans1);
    }
}