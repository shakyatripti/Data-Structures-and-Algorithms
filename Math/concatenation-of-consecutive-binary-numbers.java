//Problem: https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/description/





import java.io.*;
import java.util.*;

class BinaryNumbers {
    int mod = (int) 1000000007;
    public int concatenatedBinary(int n) {
        StringBuilder str = new StringBuilder("");
        for(int i=1; i<=n; i++) {
            str.append(convertToBinary(i));
        }
        return convertToNum(str.toString());
    }

    public String convertToBinary(int n) {
        StringBuilder str = new StringBuilder();
        while(n!=0) {
            int r = n%2;
            str.append(r);
            n=n/2;
        }
        return str.reverse().toString();
    }

    public int convertToNum(String n) {
        long ans = 0;
        long power = 1;
        int len = n.length();
        for (int i = len - 1; i >= 0; i--) {
            if (n.charAt(i) == '1') {
                ans = (ans + power) % mod;
            }
            power = (power * 2) % mod;
        }

        return (int) ans;
    }
}

class Main {
    public static void main(String[] args) {
        BinaryNumbers num = new BinaryNumbers();
        System.out.println(num.concatenatedBinary(1));
        System.out.println(num.concatenatedBinary(3));
        System.out.println(num.concatenatedBinary(12));
        System.out.println(num.concatenatedBinary(10000));
    }
}