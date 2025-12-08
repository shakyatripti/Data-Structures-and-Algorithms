//Problem: https://leetcode.com/problems/count-square-sum-triples/description/




import java.io.*;
import java.util.*;

class SquareSum {
    public int countTriples(int n) {
        int count = 0;
        for(int i=1; i<=n; i++) {
            int a = i*i;
            for(int j=1; j<=n; j++) {
                int b = j*j;
                for(int k=1; k<=n; k++) {
                    int c = k*k;
                    if(a + b == c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}


class Main {
    public static void main(String[] args) {
        SquareSum arr = new SquareSum();
        System.out.println(arr.countTriples(5));
        System.out.println(arr.countTriples(10));
    }
}