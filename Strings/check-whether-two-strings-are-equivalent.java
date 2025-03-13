//Problem: https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/description/


import java.io.*;
import java.util.*;

class EquivalentStrings {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        HashMap<Character, Integer> mp = new HashMap<Character, Integer>();
        Set<Character> st = new HashSet<>();
        for(int i=0; i<word1.length(); i++) {
            char ch = word1.charAt(i);
            st.add(ch);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> mp2 = new HashMap<Character, Integer>();
        for(int i=0; i<word2.length(); i++) {
            char ch = word2.charAt(i);
            st.add(ch);
            mp2.put(ch, mp2.getOrDefault(ch, 0) + 1);
        }

        for(char ch: st){
            int diff = 0;
            if(mp.containsKey(ch) && mp2.containsKey(ch)) {
                diff = Math.abs(mp.get(ch) - mp2.get(ch));
            } else if(mp.containsKey(ch)) {
                diff = mp.get(ch);
            } else {
                diff = mp2.get(ch);
            }
            if(diff > 3) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        EquivalentStrings str = new EquivalentStrings();
        System.out.println(str.checkAlmostEquivalent("aaaa", "bccb"));
        System.out.println(str.checkAlmostEquivalent("zzzyyy", "iiiiii"));
        System.out.println(str.checkAlmostEquivalent("abcdeef", "abaaacc"));
    }
}