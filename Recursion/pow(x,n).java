//Problem: https://leetcode.com/problems/powx-n/description/



import java.io.*;
import java.util.*;

class Power {
    public double findPower(double x, int n) {
        if(n < 0) {
            return 1/binaryExponentation(x, (long) n*-1);
        }
        return binaryExponentation(x, n);
    }
    
    public double binaryExponentation(double x, long n) {
        if(n==0) {
            return 1;
        }
        double half = binaryExponentation(x, n/2);
        double result = half * half;
        if(n%2==1) {
            result = result * x;
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        Power pow = new Power();
        System.out.println(pow.findPower(2.00000, 10));
        System.out.println(pow.findPower(2.00000, -2147483648));
        System.out.println(pow.findPower(2.00000, -2));
    }
}