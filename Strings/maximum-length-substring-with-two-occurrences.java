//Problem: https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/description/





import java.io.*;
import java.util.*;

class TwoOccurrences {
    public int maximumLength(String s) {
        int len = 0;
        for(int i=0; i<s.length(); i++) {
            int[] freq = new int[26];
            for(int j=i; j<s.length(); j++) {
                freq[s.charAt(j)-'a']++;
                if(freq[s.charAt(j)-'a'] > 2) {
                    break;
                } else {
                    len = Math.max(len, j-i+1);
                }
            }
        }
        return len;
    }
}

class Main {
    public static void main(String[] args) {
        TwoOccurrences str = new TwoOccurrences();
        System.out.println(str.maximumLength("bcbbbcba"));
        System.out.println(str.maximumLength("aaaa"));
    }
}