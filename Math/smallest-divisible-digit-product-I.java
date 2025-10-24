//Problem: https://leetcode.com/problems/smallest-divisible-digit-product-i/description/






import java.io.*;
import java.util.*;


class DigitProductI {
    public int smallestNumber(int n, int t) {
        while(!isDivisible(n, t)) {
            n++;
        }
        return n;
    }

    public boolean isDivisible(int n, int t) {
        int prod = 1;
        while(n!=0) {
            int r = n%10;
            prod*=r;
            n = n/10;
        }
        if(prod%t==0) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        DigitProductI num = new DigitProductI();
        System.out.println(num.smallestNumber(10, 2));
        System.out.println(num.smallestNumber(15, 3));
    }
}