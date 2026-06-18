//Problem: https://leetcode.com/problems/second-largest-digit-in-a-string/description/




import java.io.*;
import java.util.*;


class DigitInString {
    public int secondHighest(String s) {
        int first = -1;
        int[] num = new int[10];
        for(char ch: s.toCharArray()) {
            int val = ch - '0';
            if(val>=0 && val<=9) {
                num[val]++;
            }
        }
        
        for(int i=9; i>=0; i--) {
            if(num[i] > 0 && first==-1) {
                first = i;
            } else if (num[i] > 0 && first!=-1) {
                return i;
            }
        }
        return -1;
    }
}


class Main {
    public static void main(String[] args) {
        DigitInString digit = new DigitInString();
        System.out.println(digit.secondHighest("dfa12321afd"));
        System.out.println(digit.secondHighest("abc1111"));
    }
}