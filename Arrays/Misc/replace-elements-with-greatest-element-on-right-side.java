//Problem: https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/description/




import java.io.*;
import java.util.*;

class RightGreaterElement {
    public int[] replace(int[] arr) {
        int n=arr.length;
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            int val = 0;
            for(int j=i+1; j<n; j++) {
                val = Math.max(val, arr[j]);
            }
            ans[i] = val;
        }
        ans[n-1] = -1;
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
        RightGreaterElement num = new RightGreaterElement();
        int[] arr = {17,18,5,4,6,1};
        int[] ans = num.replace(arr);
        num.display(ans);
        
        int[] arr1 = {400};
        int[] ans1 = num.replace(arr1);
        num.display(ans1);
    }
}