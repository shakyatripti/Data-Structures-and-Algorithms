//Problem: https://leetcode.com/problems/first-letter-to-appear-twice/description/



import java.io.*;
import java.util.*;

class FirstLetter {
    public char appearsTwice(String s) {
        int[] occurrence = new int[26];
        for(char ch: s.toCharArray()) {
            int freq = ch - 'a';
            if(occurrence[freq]==1) {
                return ch;
            } else {
                occurrence[freq]++;
            }
        }
        return s.charAt(0);
    }
}

class Main {
    public static void main(String[] args) {
        FirstLetter letter = new FirstLetter();
        System.out.println(letter.appearsTwice("abccdab"));
        System.out.println(letter.appearsTwice("deeds"));
        System.out.println(letter.appearsTwice("dvvbaazv"));
    }
}