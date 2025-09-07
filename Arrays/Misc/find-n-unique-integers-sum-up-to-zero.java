//Problem: https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description/





import java.io.*;
import java.util.*;

class UniqueIntegers {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int k=1;
        for(int i=0; i < n; i+=2) {
            if(i+1 < n) {
               ans[i] = k;
               ans[i+1] = k*(-1); 
            } else {
                ans[i] = 0;
            }
            k++;
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
        UniqueIntegers arr = new UniqueIntegers();
        int[] ans = arr.sumZero(5);
        arr.display(ans);
        
        int[] ans1 = arr.sumZero(3);
        arr.display(ans1);
        
        int[] ans2 = arr.sumZero(1);
        arr.display(ans2);
        
        int[] ans3 = arr.sumZero(6);
        arr.display(ans3);
    }
}