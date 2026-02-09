//Problem: https://leetcode.com/problems/sum-of-digits-in-base-k/description/




import java.io.*;
import java.util.*;

class BaseK {
    public int sumDigits(int n, int k) {
        int sum=0;
        while(n!=0) {
            int r = n%k;
            sum+=r;
            n=n/k;
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        BaseK num = new BaseK();
        System.out.println(num.sumDigits(34,6));
        System.out.println(num.sumDigits(10, 10));
    }
}