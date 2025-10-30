//Problem: https://leetcode.com/problems/count-the-number-of-special-characters-i/description/





import java.io.*;
import java.util.*;

class SpecialCharsI {
    public int numberOfSpecialChars(String word) {
        int count = 0;
        int[] freq = new int[26];
        int[] freq1 = new int[26];
        for(char ch: word.toCharArray()) {
            int val = ch-'0';
            if(val >= 49 && val <= 74) {
                freq[ch-'a']++;
            } else {
                freq1[ch-'A']++;
            }
        }
        for(int i=0; i<26; i++) {
            if(freq[i] > 0 && freq1[i] > 0) {
                count++;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        SpecialCharsI str = new SpecialCharsI();
        System.out.println(str.numberOfSpecialChars("aaAbcBC"));
        System.out.println(str.numberOfSpecialChars("abc"));
        System.out.println(str.numberOfSpecialChars("abBCab"));
    }
}