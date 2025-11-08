//Problem: https://leetcode.com/problems/binary-number-with-alternating-bits/description/




import java.io.*;
import java.util.*;

class BinaryNumber {
    public boolean hasAlternatingBits(int n) {
        StringBuilder str = new StringBuilder("");
        while(n!=0) {
            int r = n%2;
            str.append(r);
            n=n/2;
        }
        str.reverse();
        for(int i=0; i<str.length(); i++) {
            if((i+1) < str.length() && str.charAt(i)==str.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        BinaryNumber num = new BinaryNumber();
        System.out.println(num.hasAlternatingBits(5));
        System.out.println(num.hasAlternatingBits(7));
        System.out.println(num.hasAlternatingBits(11));
    }
}