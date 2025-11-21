//Problem: https://leetcode.com/problems/count-pairs-of-similar-strings/description/





import java.io.*;
import java.util.*;

class SimilarStrings {
    public int countPairs(String[] words) {
        int count = 0;
        for(int i=0; i<words.length; i++) {
            int[] freq = countChars(words[i]);
            for(int j=i+1; j<words.length; j++) {
                int[] freq1 = countChars(words[j]);
                int flag=0;
                for(int k=0; k<26; k++){
                    if((freq[k]!=0 && freq1[k]==0) || (freq[k]==0 && freq1[k]!=0)) {
                        flag=1;
                        break;
                    }
                }
                if(flag==0) {
                   count++;
                }
            }
        }
        return count;
    }

    public int[] countChars(String word) {
        int[] freq = new int[26];
        for(char ch: word.toCharArray()) {
            freq[ch-'a']++;
        }
        return freq;
    }
}


class Main {
    public static void main(String[] args) {
        SimilarStrings str = new SimilarStrings();
        String[] words = {"aba","aabb","abcd","bac","aabc"};
        System.out.println(str.countPairs(words));
        
        String[] words1 = {"aabb","ab","ba"};
        System.out.println(str.countPairs(words1));
        
        String[] words2 = {"nba","cba","dba"};
        System.out.println(str.countPairs(words2));
    }
}