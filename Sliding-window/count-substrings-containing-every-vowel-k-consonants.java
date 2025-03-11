//Problem: https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-i/description/


import java.io.*;
import java.util.*;

class CountOfSubStrings {
    public int countValidSubstrings(String word, int k) {
        return validSubstrings(word, k) - validSubstrings(word, k+1);
    }
    
    public int validSubstrings(String word, int k) {
        int n=word.length(), ans = 0, consonants=0, l=0;
        HashMap<Character, Integer> freq = new HashMap<>(5);
        for(int i=0; i<n; i++) {
            char curr = word.charAt(i);
            if(isVowel(curr)) {
                freq.put(curr, freq.getOrDefault(curr, 0) + 1);
            } else {
                consonants++;
            }
            
            while(freq.size()==5 && consonants >=k) {
                ans+=n-i;
                char ch = word.charAt(l);
                if(isVowel(ch)) {
                    freq.put(ch, freq.get(ch)-1);
                    if(freq.get(ch)==0) {
                        freq.remove(ch);
                    }
                } else {
                    consonants--;
                }
                l++;
            }
        }
        return ans;
    }
    
    public boolean isVowel(Character ch) {
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        CountOfSubStrings str = new CountOfSubStrings();
        System.out.println(str.countValidSubstrings("ieaouqqieaouqq", 1));
        System.out.println(str.countValidSubstrings("aeiou", 0));
    }
}