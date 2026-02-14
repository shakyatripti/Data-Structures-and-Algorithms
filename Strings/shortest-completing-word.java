//Problem: https://leetcode.com/problems/shortest-completing-word/description/




import java.io.*;
import java.util.*;

class CompletingWord {
    public String shortestWord(String licensePlate, String[] words) {
        int len = Integer.MAX_VALUE;
        int[] freq = new int[26];
        String license = licensePlate.toLowerCase(), ans = "";
        for(char ch: license.toCharArray()) {
            int val = ch - 'a';
            if(val >=0 && val < 26) {
                freq[val]++;
            }
        }

        for(int i=0; i<words.length; i++) {
            int[] freq1 = new int[26];
            for(char ch: words[i].toCharArray()) {
                freq1[ch-'a']++;
            }
            if(canFormWord(freq, freq1) && len > words[i].length()) {
                len = words[i].length();
                ans = words[i];
            }
            
        }
        return ans;
    }

    public boolean canFormWord(int[] freq, int[] freq1) {
        for(int i=0; i<26; i++) {
            if(freq1[i] < freq[i]) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        CompletingWord str = new CompletingWord();
        String[] words = {"step","steps","stripe","stepple"};
        System.out.println(str.shortestWord("1s3 PSt", words));
        
        String[] words1 = {"looks","pest","stew","show"};
        System.out.println(str.shortestWord("1s3 456", words1));
    }
}