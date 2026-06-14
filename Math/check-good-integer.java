//Problem:https://leetcode.com/problems/check-good-integer/description



import java.io.*;
import java.util.*;

class GoodInteger {
    public boolean check(int n) {
        int squareSum = 0, digitSum = 0;
        while(n!=0) {
            int r = n%10;
            n = n/10;
            squareSum+=r*r;
            digitSum+=r;
        }
        int val = squareSum - digitSum;
        if(val >= 50) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        GoodInteger num = new GoodInteger();
        System.out.println(num.check(1000));
        System.out.println(num.check(19));
    }
}