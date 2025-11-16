//Problem: https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/





import java.io.*;
import java.util.*;

class PrimeNumberSetBits {
    public int countPrimeSetBits(int left, int right) {
        int prime = 0;
        for(int i=left; i<=right; i++) {
            int setBits = 0, n=i;
            while(n!=0) {
                int r=n%2;
                if(r==1) {
                    setBits++;
                }
                n=n/2;
            }
            if(isPrime(setBits)) {
                prime++;
            }
        }
        return prime;
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
        PrimeNumberSetBits num = new PrimeNumberSetBits();
        System.out.println(num.countPrimeSetBits(6,10));
        System.out.println(num.countPrimeSetBits(10,15));
    }
}