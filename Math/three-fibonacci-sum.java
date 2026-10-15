//Problem: https://leetcode.com/problems/three-fibonacci-sum/description/




import java.io.*;
import java.util.*;


class Fibonacci {
    public boolean sumOfThree(int n) {
        int s1=0, s2=1, curr=0;
        while(curr <= n) {
            int s3 = s1 + s2;
            curr = s1+s2+s3;
            if(curr==n) {
                return true;
            }
            s1 = s2;
            s2 = s3;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        Fibonacci series = new Fibonacci();
        System.out.println(series.sumOfThree(16));
        System.out.println(series.sumOfThree(8));
        System.out.println(series.sumOfThree(2));
    }
}