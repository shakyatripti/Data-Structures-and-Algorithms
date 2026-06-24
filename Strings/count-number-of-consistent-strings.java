//Problem: https://leetcode.com/problems/count-the-number-of-consistent-strings/description/



import java.io.*;
import java.util.*;


class ConsistentStrings {
    public int count(String allowed, String[] words) {
        int total = 0, n = words.length;
        for(int i=0; i<n; i++) {
            int[] freq = new int[26];
            for(char ch: words[i].toCharArray()) {
                freq[ch-'a']++;
            }

            for(int j=0; j<26; j++) {
                char ch = (char) (j + 'a');
                if(freq[j]>0 && !allowed.contains(String.valueOf(ch))) {
                    total++;
                    break;
                }
            }
        }
        return n-total;
    }
}

class Main {
    public static void main(String[] args) {
        ConsistentStrings str = new ConsistentStrings();
        String[] words = {"ad","bd","aaab","baa","badab"};
        System.out.println(str.count("ab", words));
        
        String[] words1 = {"a","b","c","ab","ac","bc","abc"};
        System.out.println(str.count("abc", words1));
        
        String[] words2 = {"cc","acd","b","ba","bac","bad","ac","d"};
        System.out.println(str.count("cad", words2));
        
        String[] words3 = {"n","eeitfns","eqqqsfs","i","feniqis","lhoa","yqyitei","sqtn","kug","z","neqqis"};
        System.out.println(str.count("fstqyienx", words3));
    }
}