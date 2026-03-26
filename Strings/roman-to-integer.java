//Problem: https://leetcode.com/problems/roman-to-integer/description/




import java.io.*;
import java.util.*;

class RomanToInteger {
    public int conversion(String s) {
        int ans = 0, i = 0;
        for(i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            char next = 'A';
            if(i < s.length() - 1) {
                next = s.charAt(i+1);
            }
            if(ch=='I') {
                if(next=='V') {
                    ans+=4;
                    i++;
                } else if(next=='X') {
                    ans+=9;
                    i++;
                } else {
                    ans+=1;
                }
            } else if(ch=='V') {
                ans+=5;
            } else if(ch=='X') {
                if(next=='L') {
                    ans+=40;
                    i++;
                } else if(next=='C') {
                    ans+=90;
                    i++;
                } else {
                    ans+=10;
                }
            } else if(ch=='L') {
                ans+=50;
            } else if(ch=='C') {
                if(next=='D') {
                    ans+=400;
                    i++;
                } else if(next=='M') {
                    ans+=900;
                    i++;
                } else {
                    ans+=100;
                }
            } else if(ch=='D') {
                ans+=500;
            } else {
                ans+=1000;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        RomanToInteger num = new RomanToInteger();
        System.out.println(num.conversion("III"));
        System.out.println(num.conversion("LVIII"));
        System.out.println(num.conversion("MCMXCIV"));
    }
}