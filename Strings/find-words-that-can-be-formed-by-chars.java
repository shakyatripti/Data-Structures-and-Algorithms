//Problem: https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/description/



import java.io.*;
import java.util.*;

class FindWords {
    public int countCharacters(String[] words, String chars) {
        int ans=0;
        int[] freq = new int[26];
        for(int i=0; i<chars.length(); i++) {
            freq[chars.charAt(i)-'a']++;
        }

        for(int i=0; i<words.length; i++) {
            int[] wordCount = new int[26];
            for(char ch: words[i].toCharArray()) {
                wordCount[ch-'a']++;
            }
            boolean isGood = true;
            for(int j=0; j<26; j++) {
                if(wordCount[j] > freq[j]) {
                    isGood = false;
                    break;
                }
            }
            if(isGood) {
               ans+=words[i].length();
            }
        }
        return ans;
    }
}


class Main {
    public static void main(String[] args) {
        FindWords obj = new FindWords();
        String[] words = {"cat","bt","hat","tree"};
        System.out.println(obj.countCharacters(words, "atach"));
        
        String[] words1 = {"hello","world","leetcode"};
        System.out.println(obj.countCharacters(words1, "welldonehoneyr"));
    }
}