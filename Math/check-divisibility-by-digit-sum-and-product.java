//Problem: https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/description/




import java.io.*;
import java.util.*;

class CheckDivisibility {
    public boolean isDivisible(int n) {
        int sum = 0, prod = 1, totalSum = 0, m=n;
        while(n!=0) {
            int r = n%10;
            n=n/10;
            sum+=r;
            prod*=r;
        }
        totalSum = prod + sum;

        if(m % totalSum==0) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        CheckDivisibility num = new CheckDivisibility();
        System.out.println(num.isDivisible(10));
        System.out.println(num.isDivisible(99));
        System.out.println(num.isDivisible(23));
    }
}