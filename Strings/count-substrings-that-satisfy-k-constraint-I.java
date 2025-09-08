//Problem: https://leetcode.com/problems/count-substrings-that-satisfy-k-constraint-i/description/




import java.io.*;
import java.util.*;

class KConstraint {
    public int countSubstrings(String s, int k) {
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            int zeroes = 0, ones = 0;
            for(int j=i; j<s.length(); j++) {
                if(s.charAt(j)=='0') {
                    zeroes++;
                } else {
                    ones++;
                }

                if(zeroes <= k || ones <= k) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        KConstraint str = new KConstraint();
        System.out.println(str.countSubstrings("10101", 1));
        System.out.println(str.countSubstrings("1010101", 2));
        System.out.println(str.countSubstrings("11111", 1));
    }
}