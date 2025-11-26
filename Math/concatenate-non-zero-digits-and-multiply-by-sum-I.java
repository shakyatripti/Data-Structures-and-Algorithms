//Problem: https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/description/






import java.io.*;
import java.util.*;

class Concatenate {
    public long sumAndMultiply(int n) {
        long sum = 0, ans = 0;
        StringBuilder res = new StringBuilder("");
        while(n!=0) {
            int r = n%10;
            if(r!=0) {
                res.append(r);
                sum+=r;
            }
            n=n/10;
        } 
        res.reverse();
        String num = res.toString();
        if(num.length() > 0) {
           ans = Long.valueOf(num);
        }
        return ans*sum;
    }
}

class Main {
    public static void main(String[] args) {
        Concatenate num = new Concatenate();
        System.out.println(num.sumAndMultiply(10203004));
        System.out.println(num.sumAndMultiply(1000));
        System.out.println(num.sumAndMultiply(0));
    }
}