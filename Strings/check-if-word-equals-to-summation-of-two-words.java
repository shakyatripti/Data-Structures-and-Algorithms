//Problem: https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/description/




import java.io.*;
import java.util.*;


class TwoWords {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int first = actualValue(firstWord);
        int second = actualValue(secondWord);
        int target = actualValue(targetWord);
        if(first + second == target) {
            return true;
        }
        return false;
    }
 
    public int actualValue(String s) {
        String num = "";
        for(int i=0; i<s.length(); i++) {
            num+=s.charAt(i) - 'a';
        }
        return Integer.valueOf(num);
    }
}

class Main {
    public static void main(String[] args) {
        TwoWords word = new TwoWords();
        System.out.println(word.isSumEqual("acb", "cba", "cdb"));
        System.out.println(word.isSumEqual("aaa", "a", "aab"));
        System.out.println(word.isSumEqual("aaa", "a", "aaaa"));
    }
}