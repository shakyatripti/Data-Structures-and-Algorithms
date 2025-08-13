//Problem: https://leetcode.com/problems/sum-multiples/description/




import java.io.*;
import java.util.*;

class SumMultiples {
    public int totalSum(int n) {
        int sum = 0;
        for(int i=3; i<=n; i++) {
            if(i%3==0 || i%5==0 || i%7==0) {
                sum+=i;
            }
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        SumMultiples multiples = new SumMultiples();
        System.out.println(multiples.totalSum(7));
        System.out.println(multiples.totalSum(10));
        System.out.println(multiples.totalSum(9));
    }
}