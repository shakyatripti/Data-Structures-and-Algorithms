//Problem: https://leetcode.com/problems/reverse-letters-then-special-characters-in-a-string/description/





import java.io.*;
import java.util.*;


class ReverseByType {
    public String reversedString(String s) {
        StringBuilder letter = new StringBuilder("");
        StringBuilder special = new StringBuilder("");
        StringBuilder ans = new StringBuilder("");
        int i=0, j=0;
        for(char ch: s.toCharArray()) {
            int val = ch - 'a';
            if(val>=0 && val<26) {
                letter.append(ch);
            } else {
                special.append(ch);
            }
        }
        letter.reverse();
        special.reverse();
        for(char ch: s.toCharArray()) {
            int val = ch - 'a';
            if(val>=0 && val<26) {
                ans.append(letter.charAt(i));
                i++;
            } else {
                ans.append(special.charAt(j));
                j++;
            }
        }
        return ans.toString();
    }
}

class Main {
    public static void main(String[] args) {
        ReverseByType str = new ReverseByType();
        System.out.println(str.reversedString(")ebc#da@f("));
        System.out.println(str.reversedString("z"));
        System.out.println(str.reversedString("!@#$%^&*()"));
    }
}