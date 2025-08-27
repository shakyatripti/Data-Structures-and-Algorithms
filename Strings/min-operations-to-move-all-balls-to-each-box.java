//Problem: https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/





import java.io.*;
import java.util.*;

class MoveBallstoEachBox {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=0; j<n; j++) {
                char ch = boxes.charAt(j);
                if(ch=='1') {
                    sum+=Math.abs(i-j);
                }
            }
            ans[i] = sum;
        }
        return ans;
    }
    
    public void display(int[] ans) {
        if(ans.length==0) {
            System.out.print("empty");
        }
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        MoveBallstoEachBox box = new MoveBallstoEachBox();
        int[] ans = box.minOperations("110");
        box.display(ans);
        
        int[] ans1 = box.minOperations("001011");
        box.display(ans1);
    }
}