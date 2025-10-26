//Problem: https://leetcode.com/problems/longest-balanced-substring-i/description/





import java.io.*;
import java.util.*;

class BalancedSubstringI {
    public int longestBalanced(String s) {
        int len = 1;
        for(int i=0; i<s.length(); i++) {
            int[] freq = new int[26];
            for(int j=i; j<s.length(); j++) {
                freq[s.charAt(j)-'a']++;
                if(hasSameChars(freq)) {
                    len = Math.max(len, j-i+1);
                }
            }
        }
        return len;
    }

    public boolean hasSameChars(int[] freq) {
        Set<Integer> st = new HashSet<>();
        for(int i=0; i<26; i++) {
            if(freq[i]!=0) {
                st.add(freq[i]);
            }
            if(st.size() > 1) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        BalancedSubstringI substr = new BalancedSubstringI();
        System.out.println(substr.longestBalanced("abbac"));
        System.out.println(substr.longestBalanced("zzabccy"));
        System.out.println(substr.longestBalanced("aba"));
    }
}