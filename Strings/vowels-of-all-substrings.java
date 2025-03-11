//Problem: https://leetcode.com/problems/vowels-of-all-substrings/description/


import java.io.*;
import java.util.*;

class CountVowelSubStrings {
    public long vowelSubstrings(String word) {
        int n=word.length();
        long ans = 0L;
        for(int i=0; i<n; i++) {
            char ch = word.charAt(i);
            if(isVowel(ch)) {
                ans+=(long) (n-i) * (i+1);
            }
        }
        return ans;
    }
    
    public boolean isVowel(Character ch) {
        if(ch=='a' || ch=='e' || ch=='i' || ch=='u' || ch=='o') {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        CountVowelSubStrings str = new CountVowelSubStrings();
        System.out.println(str.vowelSubstrings("aba"));
        System.out.println(str.vowelSubstrings("aaabc"));
        System.out.println(str.vowelSubstrings("lkjn"));
    }
}