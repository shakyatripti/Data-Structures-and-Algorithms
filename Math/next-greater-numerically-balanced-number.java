//Problem: https://leetcode.com/problems/next-greater-numerically-balanced-number/description/




import java.io.*;
import java.util.*;

class BalancedNumber {
    public int nextBeautifulNumber(int n) {
        n = n+1;
        while(!isBalanced(n)) {
            n++;
        }
        return n;
    }

    public boolean isBalanced(int n) {
        int[] freq = new int[10];
        while(n!=0) {
            int r = n%10;
            n=n/10;
            freq[r]++;
        }
        for(int i=0; i<10; i++) {
            if(freq[i]!=0 && freq[i]!=i) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        BalancedNumber num = new BalancedNumber();
        System.out.println(num.nextBeautifulNumber(1));
        System.out.println(num.nextBeautifulNumber(1000));
        System.out.println(num.nextBeautifulNumber(3000));
    }
}