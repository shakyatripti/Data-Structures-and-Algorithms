//Problem: https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/description/




import java.io.*;
import java.util.*;


class CheckCharacters {
    public boolean areOccurrencesEqual(String s) {
        Set<Integer> st = new HashSet<>();
        int[] freq = new int[26];
        for(char ch: s.toCharArray()) {
            freq[ch-'a']++;
        }

        for(int i=0; i<26; i++) {
            if(freq[i]!=0) {
                st.add(freq[i]);
            }
        }

        if(st.size()==1) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        CheckCharacters str = new CheckCharacters();
        System.out.println(str.areOccurrencesEqual("abacbc"));
        System.out.println(str.areOccurrencesEqual("aaabb"));
    }
}