//Problem: https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/description/




import java.io.*;
import java.util.*;



class SequenceOfSentences {
    public int mostWordsFound(String[] sentences) {
        int words = 0;
        for(int i=0; i<sentences.length; i++) {
            String[] str = sentences[i].split("\\ ");
            words = Math.max(words, str.length);
        }
        return words;
    }
}

class Main {
    public static void main(String[] args) {
        SequenceOfSentences str = new SequenceOfSentences();
        String[] sentences = {"alice and bob love leetcode","i think so too","this is great thanks very much"};
        System.out.println(str.mostWordsFound(sentences));
        
        String[] sentences1 = {"please wait","continue to fight","continue to win"};
        System.out.println(str.mostWordsFound(sentences1));
    }
}