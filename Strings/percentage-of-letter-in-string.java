//Problem: https://leetcode.com/problems/percentage-of-letter-in-string/description/




import java.io.*;
import java.util.*;

class LetterPercentage {
    public int percent(String s, char letter) {
        int len = s.length(), freq=0;
        for(char ch: s.toCharArray()) {
            if(letter==ch) {
                freq++;
            }
        }
        return ((freq*100)/len);
    }
}

class Main {
    public static void main (String[] args) {
        LetterPercentage word = new LetterPercentage();
        System.out.println(word.percent("foobar", 'o'));
        System.out.println(word.percent("jjjj", 'k'));
    }
}