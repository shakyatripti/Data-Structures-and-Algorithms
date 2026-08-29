//Problem: https://leetcode.com/problems/replace-all-digits-with-characters/description/




import java.io.*;
import java.util.*;

class DigitsWithCharacters {
    public String replace(String s) {
        StringBuilder str = new StringBuilder("");
        for(int i=0; i<s.length(); i++) {
            if(i%2!=0) {
                int val = s.charAt(i) - '0';
                str.append((char) (s.charAt(i-1) + val));
            } else {
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}

class Main {
    public static void main(String[] args) {
        DigitsWithCharacters ch = new DigitsWithCharacters();
        System.out.println(ch.replace("a1c1e1"));
        System.out.println(ch.replace("a1b2c3d4e"));
    }
}