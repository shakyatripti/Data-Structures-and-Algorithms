//Problem: https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/description/



import java.io.*;
import java.util.*;


class TypeWordI {
    public int minimumPushes(String word) {
        int n=word.length();
        if(n <= 8) {
            return n;
        } else if(n > 8 && n <= 16) {
            return 8 + 2*(n-8);
        } else if(n > 16 && n <= 24) {
            return 24 + 3*(n-16);
        } else {
            return 48 + 4*(n-24);
        }
    }
}

class Main {
    public static void main(String[] args) {
        TypeWordI keypad = new TypeWordI();
        System.out.println(keypad.minimumPushes("abcde"));
        System.out.println(keypad.minimumPushes("xycdefghij"));
        System.out.println(keypad.minimumPushes("acolkxjbizfmhnrdq"));
        System.out.println(keypad.minimumPushes("amrvxnhsewkoipjyuclgtdbfq"));
    }
}