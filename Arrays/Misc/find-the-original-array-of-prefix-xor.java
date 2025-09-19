//Problem: https://leetcode.com/problems/find-the-original-array-of-prefix-xor/description/




import java.io.*;
import java.util.*;

class OriginalArray {
    public int[] prefixXOR(int[] pref) {
        int[] ans = new int[pref.length];
        ans[0] = pref[0];
        for(int i=1; i<pref.length; i++) {
            ans[i] = pref[i] ^ pref[i-1];  
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
        OriginalArray arr = new OriginalArray();
        int[] pref = {5,2,0,3,1};
        int[] ans = arr.prefixXOR(pref);
        arr.display(ans);
        
        int[] pref1 = {14};
        int[] ans1 = arr.prefixXOR(pref1);
        arr.display(ans1);
    }
}