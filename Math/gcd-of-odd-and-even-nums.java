//Problem: https://leetcode.com/problems/gcd-of-odd-and-even-sums/description/




import java.util.*;
import java.io.*;


class GCDOfEvenOddSums {
    public int gcdOfOddEvenSums(int n) {
        int nums = 2*n, evens=0, odds=0;
        for(int i=1; i<=nums; i++) {
            if(i%2==0) {
                evens+=i;
            } else {
                odds+=i;
            }
        }
        return findGcd(odds, evens);
    }

    public int findGcd(int a, int b) {
        if(b==0) {
            return a;
        }
        return findGcd(b, a%b);
    }
}


class Main {
    public static void main(String[] args) {
        GCDOfEvenOddSums num = new GCDOfEvenOddSums();
        System.out.println(num.gcdOfOddEvenSums(4));
        System.out.println(num.gcdOfOddEvenSums(5));
    }
}