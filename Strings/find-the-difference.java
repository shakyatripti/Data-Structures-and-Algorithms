//Problem: https://leetcode.com/problems/find-the-difference/description/




import java.io.*;
import java.util.*;

class FindTheDifference {
    public char difference(String s, String t) {
        int[] countOfT = new int[26];
        for(int i=0; i<t.length(); i++) {
            int ch = t.charAt(i) - 'a';
            countOfT[ch]++;
        }

        int[] countOfS = new int[26];
        for(int i=0; i<s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            countOfS[ch]++;
        }

        for(int i=0; i<t.length(); i++) {
            int ch = t.charAt(i) - 'a';
            if(countOfS[ch]!=countOfT[ch]) {
                return t.charAt(i);
            }
        }
        return t.charAt(0);
    }
}

class Main {
    public static void main(String[] args) {
        FindTheDifference diff = new FindTheDifference();
        System.out.println(diff.difference("abcd", "abcde"));
        System.out.println(diff.difference("", "y"));
        System.out.println(diff.difference("aecdr", "aecsdr"));
    }
}