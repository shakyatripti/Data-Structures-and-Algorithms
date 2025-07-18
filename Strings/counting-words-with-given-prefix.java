//Problem: https://leetcode.com/problems/counting-words-with-a-given-prefix/description/




import java.io.*;
import java.util.*;

class CountingWords {
    public int prefixCount(String[] words, String pref) {
        int n=pref.length(), count=0;
        for(int i=0; i<words.length; i++) {
            if(words[i].length() >= n) {
                String str = words[i].substring(0, n);
                if(str.equals(pref)) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        CountingWords obj = new CountingWords();
        String[] words = {"pay","attention","practice","attend"};
        System.out.println(obj.prefixCount(words, "at"));
        
        String[] words1 = {"leetcode","win","loops","success"};
        System.out.println(obj.prefixCount(words1, "leet"));
        
        String[] words2 = {"sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh","sxyjellhlh"};
        System.out.println(obj.prefixCount(words2, "sxyjellhlh"));
    }
}