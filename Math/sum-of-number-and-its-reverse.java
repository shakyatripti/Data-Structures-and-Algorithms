//Problem: https://leetcode.com/problems/sum-of-number-and-its-reverse/description/




import java.io.*;
import java.util.*;



class NumberAndReverse {
    public boolean findSum(int num) {
        for(int i=0; i<=num; i++) {
            int first = i;
            int second = reverse(i);
            if(first+second==num) {
                return true;
            }
        }
        return false; 
    }

    public int reverse(int n) {
        int ans = 0;
        while(n!=0) {
            int r = n%10;
            ans = (ans * 10) + r;
            n=n/10;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        NumberAndReverse arr = new NumberAndReverse();
        System.out.println(arr.findSum(443));
        System.out.println(arr.findSum(63));
        System.out.println(arr.findSum(181));
        System.out.println(arr.findSum(0));
    }
}