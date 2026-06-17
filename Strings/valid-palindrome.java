//Problem: https://leetcode.com/problems/valid-palindrome/description/



import java.io.*;
import java.util.*;

class Palindrome {
    public boolean isValid (String s) {
        String lower = s.toLowerCase();
        StringBuilder str = new StringBuilder();
        for(char ch: lower.toCharArray()) {
            int val = ch - 'a';
            int num = ch - '0';
            if(val>=0 && val<26) {
                str.append(ch);
            }
            if(num>=0 && num<10) {
                str.append(ch);
            }
        }
        String org = str.toString();
        String rev = str.reverse().toString();
        if(org.equals(rev)) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        Palindrome str = new Palindrome();
        System.out.println(str.isValid("A man, a plan, a canal: Panama"));
        System.out.println(str.isValid("race a car"));
        System.out.println(str.isValid(" "));
        System.out.println(str.isValid("0P"));
    }
}