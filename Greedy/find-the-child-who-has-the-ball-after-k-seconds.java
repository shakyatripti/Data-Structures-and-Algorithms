//Problem: https://leetcode.com/problems/find-the-child-who-has-the-ball-after-k-seconds/description/




import java.io.*;
import java.util.*;

class ChildWithBall {
    public int numberOfChild(int n, int k) {
        int j=0, flag=0;
        int[] num = new int[n];
        for(int i=0; i<n; i++) {
            num[i] = i;
        }

        while(k > 0) {
            if(j==0) {
                flag=0;
                j++;
            } else if(j==n-1) {
                flag=1;
                j--;
            } else if(flag==0 && j!=n-1) {
                j++;
            } else if(flag==1 && j!=0) {
                j--;
            }
            k--;
        }
        return j;
    }
}

class Main {
    public static void main(String[] args) {
        ChildWithBall ball = new ChildWithBall();
        System.out.println(ball.numberOfChild(3,5));
        System.out.println(ball.numberOfChild(5,6));
        System.out.println(ball.numberOfChild(4,2));
    }
}