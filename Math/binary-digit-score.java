//Problem: https://leetcode.com/problems/binary-digit-score/description/





import java.io.*;
import java.util.*;


class BinaryDigit {
    public int calculateScore(int a, int b) {
        int s1 = countSetBits(a);
        int s2 = countSetBits(b);
        if(s1>=s2) {
            return s1*s2;
        }
        return s2/s1;
    }

    public int countSetBits(int n) {
        int count = 0;
        while(n!=0) {
            int r = n%2;
            if(r==1) {
                count++;
            }
            n=n/2;
        }
        return count;
    }
}


class Main {
    public static void main(String[] args) {
        BinaryDigit digit = new BinaryDigit();
        System.out.println(digit.calculateScore(14, 6));
        System.out.println(digit.calculateScore(5, 15));
        System.out.println(digit.calculateScore(10, 12));
    }
}