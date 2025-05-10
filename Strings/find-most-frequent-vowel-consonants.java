//Problem: https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/description/




import java.io.*;
import java.util.*;

class FrequentVowelConsonant {
    public int mostFrequent(String s) {
        int vowel=0, consonant=0;
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            freq[ch]++;
        }
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='u' || ch=='i' || ch=='o') {
                vowel = Math.max(vowel, freq[ch-'a']);
            } else {
                consonant = Math.max(consonant, freq[ch-'a']);
            }
        }
        return vowel + consonant;
    }
}

class Main {
    public static void main(String[] args) {
        FrequentVowelConsonant obj = new FrequentVowelConsonant();
        String s = "successes";
        System.out.println(obj.mostFrequent(s));
        
        String s1 = "aeiaeia";
        System.out.println(obj.mostFrequent(s1));
        
        String s2 = "computer";
        System.out.println(obj.mostFrequent(s2));
    }
}