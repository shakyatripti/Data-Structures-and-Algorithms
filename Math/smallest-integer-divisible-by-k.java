//Problem: https://leetcode.com/problems/smallest-integer-divisible-by-k/description/





import java.io.*;
import java.util.*;

class SmallestInteger {
    public int divisibleByK(int k) {
        int rem = 0;
        for(int i=1; i<=k; i++) {
            rem = (rem*10 + 1) % k;
            if(rem==0) {
                return i;
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        SmallestInteger num = new SmallestInteger();
        System.out.println(num.divisibleByK(1));
        System.out.println(num.divisibleByK(2));
        System.out.println(num.divisibleByK(3));
    }
}