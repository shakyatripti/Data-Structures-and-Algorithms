//Problem: https://leetcode.com/problems/maximum-product-of-word-lengths/description/




import java.io.*;
import java.util.*;


class WordsLength {
    public int maxProduct(String[] words) {
        int ans = 0;
        for(int i=0; i<words.length; i++) {
            for(int j=i+1; j<words.length; j++) {
                if(areSame(words[i], words[j])) {
                    int len = words[i].length() * words[j].length();
                    ans = Math.max(ans, len);
                }
            }
        }
        return ans;
    }

    public boolean areSame(String s1, String s2) {
        int[] freq = new int[26];
        for(int i=0; i<s1.length(); i++) {
            freq[s1.charAt(i)-'a']++;
        }

        for(int i=0; i<s2.length(); i++) {
            if(freq[s2.charAt(i)-'a']!=0) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        WordsLength str = new WordsLength();
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(str.maxProduct(words));
        
        String[] words1 = {"a","ab","abc","d","cd","bcd","abcd"};
        System.out.println(str.maxProduct(words1));
        
        String[] words2 = {"a","aa","aaa","aaaa"};
        System.out.println(str.maxProduct(words2));
    }
}