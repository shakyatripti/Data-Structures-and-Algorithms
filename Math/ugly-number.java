//Problem: https://leetcode.com/problems/ugly-number/description/




import java.io.*;
import java.util.*;

class UglyNumber {
    public boolean isUgly(int n) {
        if(n <= 0) {
            return false;
        }
        while(n > 1) {
            if(n%2==0) {
                n=n/2;
            } else if(n%3==0) {
                n=n/3;
            } else if(n%5==0) {
                n=n/5;
            } else {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        UglyNumber num = new UglyNumber();
        System.out.println(num.isUgly(6));
        System.out.println(num.isUgly(1));
        System.out.println(num.isUgly(14));
        System.out.println(num.isUgly(-2147483648));
    }
}