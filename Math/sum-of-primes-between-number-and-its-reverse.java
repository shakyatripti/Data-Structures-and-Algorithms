//Problem: https://leetcode.com/problems/sum-of-primes-between-number-and-its-reverse/description/




import java.io.*;
import java.util.*;

class PrimesInRange {
    public int calcSum(int n) {
        int sum = 0, m = n;
        String str = "";
        while(n!=0) {
            int r = n%10;
            str+=r;
            n=n/10;
        }
        int rev = Integer.valueOf(str);
        int start = Math.min(rev, m);
        int end = Math.max(rev, m);
        for(int i=start; i<=end; i++) {
            if(isPrime(i)) {
                sum+=i;
            }
        }
        return sum;
    }

    public boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }
        if(n==2) {
            return true;
        }
        if(n%2==0) {
            return false;
        }
        for(int i=3; i*i<=n; i+=2) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        PrimesInRange prime = new PrimesInRange();
        System.out.println(prime.calcSum(13));
        System.out.println(prime.calcSum(10));
        System.out.println(prime.calcSum(8));
    }
}