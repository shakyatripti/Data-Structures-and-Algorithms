//Problem: https://leetcode.com/problems/count-substrings-with-k-frequency-characters-i/description/




import java.io.*;
import java.util.*;

class KFrequencyCharsI {
    public int numberOfSubstrings(String s, int k) {
        int count = 0, n = s.length();
        for(int i=0; i<n; i++) {
            int[] freq = new int[26];
            for(int j=i; j<n; j++) {
                char ch = s.charAt(j);
                freq[ch-'a']++;
                if(freq[ch-'a'] >= k) {
                    count+=n-j;
                    break;
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        KFrequencyCharsI str = new KFrequencyCharsI();
        System.out.println(str.numberOfSubstrings("abacb", 2));
        System.out.println(str.numberOfSubstrings("abcde", 1));
        System.out.println(str.numberOfSubstrings("ajsrhoebe", 2));
    }
}