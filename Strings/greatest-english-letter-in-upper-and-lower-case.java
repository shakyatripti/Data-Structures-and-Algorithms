//Problem: https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/description/





import java.io.*;
import java.util.*;

class EnglishLetter {
    public String greatestLetter(String s) {
        int res = -1;
        String ans = "";
        int[] freq = new int[26];
        for(char ch:s.toCharArray()) {
            int val = ch - 'a';
            if(val>=0 && val<=26) {
                freq[val]++;
            }
        }

        for(char ch: s.toCharArray()) {
            int val = ch - 'A';
            if(val>=0 && val<=26 && freq[val] > 0 && res < val) {
                res = val;
                ans = Character.toString(ch);
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        EnglishLetter letter = new EnglishLetter();
        System.out.println(letter.greatestLetter("lEeTcOdE"));
        System.out.println(letter.greatestLetter("arRAzFif"));
        System.out.println(letter.greatestLetter("AbCdEfGhIjK"));
        System.out.println(letter.greatestLetter("AaAaBbBb"));
    }
}