//Problem: https://leetcode.com/problems/defuse-the-bomb/description/





import java.io.*;
import java.util.*;


class DefuseTheBomb {
    public int[] decrypt(int[] code, int k) {
        int n=code.length;
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            if(k > 0) {
                int sum = 0;
                for(int j=0; j<k; j++) {
                    sum+=code[(i+j+1)%n];
                }
                ans[i] = sum;
            } else if(k < 0) {
                int step = Math.abs(k), sum = 0;
                for(int j=1; j<=step; j++) {
                    sum+=code[(i-j+n)%n];
                }
                ans[i] = sum;
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
        DefuseTheBomb bomb = new DefuseTheBomb();
        int[] code = {5,7,1,4};
        int[] ans = bomb.decrypt(code, 3);
        bomb.display(ans);
        
        int[] code1 = {1,2,3,4};
        int[] ans1 = bomb.decrypt(code1, 0);
        bomb.display(ans1);
        
        int[] code2 = {2,4,9,3};
        int[] ans2 = bomb.decrypt(code2, -2);
        bomb.display(ans2);
    }
}