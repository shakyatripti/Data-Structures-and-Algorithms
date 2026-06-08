//Problem: https://leetcode.com/problems/exactly-one-consecutive-set-bits-pair/description/



import java.io.*;
import java.util.*;

class BitsPair {
    public boolean consecutiveSetBits(int n) {
        int prev = -1, count = 0;
        while(n!=0) {
            int r = n%2;
            n=n/2;
            if(r==1 && prev == 1) {
                count++;
            }
            prev = r;
        }
        if(count==1) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        BitsPair pair = new BitsPair();
        System.out.println(pair.consecutiveSetBits(6));
        System.out.println(pair.consecutiveSetBits(5));
        System.out.println(pair.consecutiveSetBits(30));
    }
}