//Problem: https://leetcode.com/problems/find-the-longest-balanced-substring-of-a-binary-string/description/




import java.io.*;
import java.util.*;

class BalancedSubstring {
    public int findTheLongest(String s) {
        int n=s.length(), ans=0;
        for(int i=0; i<n; i++) {
            int zeroes=0, ones=0, lastZero=-1, firstOne=n;
            for(int j=i; j<n; j++) {
                if(s.charAt(j)=='0') {
                    zeroes++;
                    lastZero = Math.max(j, lastZero);
                } else {
                    ones++;
                    firstOne = Math.min(firstOne, j);
                }

                if(zeroes==ones && lastZero < firstOne) {
                    ans = Math.max(ans, j-i+1);
                }
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        BalancedSubstring substr = new BalancedSubstring();
        System.out.println(substr.findTheLongest("01000111"));
        System.out.println(substr.findTheLongest("00111"));
        System.out.println(substr.findTheLongest("111"));
    }
}