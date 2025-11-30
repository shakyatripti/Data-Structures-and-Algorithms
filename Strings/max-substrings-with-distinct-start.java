//Problem: https://leetcode.com/problems/maximum-substrings-with-distinct-start/description/





import java.io.*;
import java.util.*;

class DistinctStart {
    public int maxSubstrings(String s) {
        int count = 0;
        int[] freq = new int[26];
        for(char ch: s.toCharArray()) {
            freq[ch-'a']++;
        }

        for(int i=0; i<26; i++) {
            if(freq[i] > 0) {
                count++;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        DistinctStart str = new DistinctStart();
        System.out.println(str.maxSubstrings("abab"));
        System.out.println(str.maxSubstrings("abcd"));
        System.out.println(str.maxSubstrings("aaa"));
    }
}