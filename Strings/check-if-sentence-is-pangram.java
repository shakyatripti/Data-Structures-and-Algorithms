//Problem: https://leetcode.com/problems/check-if-the-sentence-is-pangram/description/




import java.io.*;
import java.util.*;

class PangramSentence {
    public boolean check (String sentence) {
        int[] freq = new int[26];
        for(char ch: sentence.toCharArray()) {
            freq[ch-'a']++;
        }

        for(int i=0; i<26; i++) {
            if(freq[i]==0) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        PangramSentence str = new PangramSentence();
        System.out.println(str.check("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(str.check("leetcode"));
        System.out.println(str.check("jwtucoucmdfwxxqnxzkaxoglszmfrcvjoiunqqausaxxaaijyqdqgvdnqcaihwilqkpivenpnekioyqujrdrovqrlxovcucjqzjsxmllfgndfprctxvxwlzjtciqxgsxfwhmuzqvlksyuztoetyjugmswfjtawwaqmwyxmvo"));
    }
}