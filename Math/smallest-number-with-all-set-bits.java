//Problem: https://leetcode.com/problems/smallest-number-with-all-set-bits/description/






import java.io.*;
import java.util.*;

class AllSetBits {
    public int smallestNumber(int n) {
        while(!setBits(n)) {
            n++;
        }
        return n;
    }

    public boolean setBits(int n) {
        while(n!=0) {
            int r = n%2;
            if(r==0) {
                return false;
            }
            n=n/2;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        AllSetBits num = new AllSetBits();
        System.out.println(num.smallestNumber(5));
        System.out.println(num.smallestNumber(10));
        System.out.println(num.smallestNumber(3));
    }
}